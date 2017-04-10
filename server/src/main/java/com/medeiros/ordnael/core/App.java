package com.medeiros.ordnael.core;

import java.time.LocalDateTime;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Usuario;
import com.medeiros.ordnael.casa.resource.acesso.AcessoResource;
import com.medeiros.ordnael.casa.resource.acesso.AcessoTipo;
import com.medeiros.ordnael.casa.resource.usuario.UsuarioResource;
import com.medeiros.ordnael.core.crypto.Crypto;

@ApplicationPath("/rest")
public class App extends Application {
	
	@Context
	public static ServletContext context;
	
	private static Integer teste = 0;
	
	@Override
	public Set<Object> getSingletons() {
		
		teste ++;
		if (teste==1) {
			
			try (UsuarioResource usuRes = new UsuarioResource()) {
				
				@SuppressWarnings("resource")
				AcessoResource acessRes = new AcessoResource(usuRes);
				
				Usuario admin = usuRes.busca(1);
				if (admin==null) {
					
					Acesso acesso = new Acesso();
					acesso.setNomeacesso("admin");
					acesso.setTipo(AcessoTipo.ADMIN);
					acesso.setSenha(new Crypto().criptografar("admin"));
					acesso.setData(LocalDateTime.now());
					
					acesso.setToken(
						new Crypto().criptografar(acesso.getNomeacesso()+";"+acesso.getData().toString()) +
						new Crypto().criptografar(acesso.getSenha()+";"+acesso.getData().toString())
					);
					
					acessRes.incluir(acesso);
					
					admin = new Usuario();
					admin.setNome("Administrador");
					admin.setEmail("admin@casa.com");
					admin.setAcesso(acesso);
					
					usuRes.incluir(admin);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		return super.getSingletons();
	}
	
	public App() {
	}
	
}