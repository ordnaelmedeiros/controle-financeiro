package com.medeiros.ordnael.casa.resource.teste;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.casa.entity.ObjetoTeste;
import com.medeiros.ordnael.core.email.Email;
import com.medeiros.ordnael.core.rest.RestSessao;

@Path("/teste")
public class TesteController {

	@Inject
	RestSessao sessao; 
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "ping: " + LocalDateTime.now();
	}
	
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String html() {
		try {
			new Email().sendEmail();
			return "<html><body><h1>Teste</h1>teste 2</body></html>";
		} catch (Exception e) {
			return "<html><body><h1>Erro:</h1>"+e.getMessage()+"</body></html>";
		}
		
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetoTeste json() {
		ObjetoTeste obj = new ObjetoTeste();
		obj.criar();
		return obj;
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ObjetoTeste xml() {
		ObjetoTeste obj = new ObjetoTeste();
		obj.criar();
		return obj;
	}
	
}
