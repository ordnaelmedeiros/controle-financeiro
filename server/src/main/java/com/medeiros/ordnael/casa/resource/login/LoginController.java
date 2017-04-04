package com.medeiros.ordnael.casa.resource.login;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Sessao;
import com.medeiros.ordnael.casa.resource.acesso.AcessoResource;
import com.medeiros.ordnael.casa.resource.sessao.SessaoResource;
import com.medeiros.ordnael.core.crypto.Crypto;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
	
	@Context
	HttpServletRequest context;
	
	@SuppressWarnings("resource")
	@POST
	public Response logar(Login login) throws Exception {
		
		try (AcessoResource acessoRes = new AcessoResource()) {
			
			Acesso acesso = acessoRes.buscaPorNomeDeAcesso(login.getUsuario());
			
			if (acesso==null) {
				return this.statusLoginOuSenhaInvalidos();
			}
			
			String senhaCrypto = new Crypto().criptografar(login.getSenha());
			
			if (acesso.getSenha().equals(senhaCrypto)) {
				
				Sessao sessao = new Sessao();
				sessao.setAcesso(acesso);
				sessao.setData(LocalDateTime.now());
				sessao.setIp(context.getRemoteHost()+"-"+context.getRemoteAddr());
				sessao.setUseragent(context.getHeader("User-Agent"));
				sessao.setToken(
					new Crypto().criptografar(acesso.getId()+";"+sessao.getUseragent()+";"+sessao.getData().toString())+
					new Crypto().criptografar(acesso.getId()+";"+sessao.getIp()+";"+sessao.getData().toString())
				);
				
				SessaoResource sessaoResource = new SessaoResource(acessoRes);
				sessaoResource.incluir(sessao);
				
				login.setUsertoken(acesso.getToken());
				login.setSessaotoken(sessao.getToken());
				
				return Response.ok(login).build();
				
			} else {
				
				return this.statusLoginOuSenhaInvalidos();
				
			}
			
		} catch (NoResultException e) {
			
			return this.statusLoginOuSenhaInvalidos();
			
		} catch (Exception e) {
			
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			
		}
		
	}
	
	private Response statusLoginOuSenhaInvalidos() {
		return Response.status(Status.BAD_REQUEST).entity("Login ou Senha inválidos.").build();
	}
	
}
