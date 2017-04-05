package com.medeiros.ordnael.core.rest.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.medeiros.ordnael.core.rest.RestSessao;

@Provider
public class RequestFilter implements ContainerRequestFilter {

	private long contador = 0;
	
	@Inject
	RestSessao sessao;
	
	@Context
	HttpServletRequest context;
	
	private boolean verificaPermissaoTotal(String pathInfo) {
		return (pathInfo.equals("/login") || pathInfo.indexOf("/teste")==0 || pathInfo.lastIndexOf("/help")>=0);
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String pathInfo = context.getPathInfo();
		if (!this.verificaPermissaoTotal(pathInfo)) {
			throw new IOException("Permissão negada");
		}
		
		System.out.println("URL: " + context.getRemoteHost()+"-"+context.getRemoteAddr());
		System.out.println("User-Agent: " + context.getHeader("User-Agent"));
		System.out.println("usuariotoken: " + context.getHeader("User-Token"));
		System.out.println("sessaotoken: " + context.getHeader("Session-Token"));
		System.out.println("metodo: " + pathInfo);
		
		this.contador++;
		//		sessao.setTexto(" -> " + this.contador);
		System.out.println("RequestFilter: " +this.contador);
		
		//throw new IOException("teste");
		
	}

}
