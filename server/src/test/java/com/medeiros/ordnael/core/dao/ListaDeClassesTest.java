package com.medeiros.ordnael.core.dao;

import javax.ws.rs.client.ClientBuilder;

import org.junit.Assert;
import org.junit.Test;

public class ListaDeClassesTest {

	@Test
	public void testeClassesNoPacote() {
		
		try {
			Boolean certo = ClientBuilder.newClient().target("http://localhost:8080/casa/rest/teste/testelistaclasses").request().get(Boolean.class);
			Assert.assertTrue("Não achou classes", certo);
		} catch (Exception e) {
			Assert.assertTrue("Não achou classes", false);
		}
		
	}
	
}
