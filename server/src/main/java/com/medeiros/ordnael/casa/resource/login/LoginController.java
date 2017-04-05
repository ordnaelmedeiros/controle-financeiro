package com.medeiros.ordnael.casa.resource.login;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Sessao;
import com.medeiros.ordnael.casa.entity.Usuario;
import com.medeiros.ordnael.casa.resource.acesso.AcessoResource;
import com.medeiros.ordnael.casa.resource.sessao.SessaoResource;
import com.medeiros.ordnael.casa.resource.usuario.UsuarioResource;
import com.medeiros.ordnael.core.crypto.Crypto;
import com.medeiros.ordnael.core.rest.filters.RestException;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginController {
	
	@Context
	HttpServletRequest context;
	
	private RestException loginOuSenhaInvalidos = new RestException("Login ou Senha inválidos.");
	
	@SuppressWarnings("resource")
	@POST
	public Login logar(Login login) throws RestException {
		
		try (AcessoResource acessoRes = new AcessoResource()) {
			
			Acesso acesso = acessoRes.buscaPorNomeDeAcesso(login.getNomeacesso());
			
			if (acesso==null) {
				throw loginOuSenhaInvalidos;
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
				
				UsuarioResource usuarioResource = new UsuarioResource(acessoRes);
				Usuario usuario = usuarioResource.buscarPeloAcesso(acesso);
				
				login.setUsertoken(acesso.getToken());
				login.setSessaotoken(sessao.getToken());
				login.setUsuario(usuario);
				
				return login;
				
			} else {
				
				throw loginOuSenhaInvalidos;
				
			}
			
		} catch (NoResultException e) {
			
			throw loginOuSenhaInvalidos;
			
		} catch (Exception e) {
			
			throw new RestException(e.getMessage());
			
		}
		
	}
	
}