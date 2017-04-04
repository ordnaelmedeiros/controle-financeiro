package com.medeiros.ordnael.core;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Table;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Usuario;
import com.medeiros.ordnael.casa.resource.acesso.AcessoResource;
import com.medeiros.ordnael.casa.resource.acesso.AcessoTipo;
import com.medeiros.ordnael.casa.resource.usuario.UsuarioResource;
import com.medeiros.ordnael.core.crypto.Crypto;
import com.medeiros.ordnael.core.dao.ListaDeClasses;

@ApplicationPath("/rest")
public class App extends Application {
	
	private static Integer teste = 0;
	
	public App() {
		
		try {
			
			//String path= System.getProperty("user.dir");
			
			//System.out.println("path: " + path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		teste ++;
		if (teste==1) {
			
			System.out.println("----->>> aqui");
			
			try {
				
				List<Class<?>> classes = new ListaDeClasses("com.medeiros.ordnael.casa.model").getClasses();
				System.out.println("Inicio Classes");
				for (Class<?> classe : classes) {
					if (classe.isAnnotationPresent(Table.class)) {
						System.out.println("--> " + classe.getSimpleName());
					}
				}
				
			} catch (Exception e) {
				System.out.println("----->>> aqui erro");
			}
			
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
		
	}
	
}