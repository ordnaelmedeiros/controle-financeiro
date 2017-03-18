package com.medeiros.ordnael.controlefinanceiro.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.controlefinanceiro.model.ObjetoTeste;

@Path("/teste")
public class TesteController {

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String html() {
		return "<html><body><h1>Teste</h1>teste 2</body></html>";
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
