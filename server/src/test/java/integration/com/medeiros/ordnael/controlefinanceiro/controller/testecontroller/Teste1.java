package integration.com.medeiros.ordnael.controlefinanceiro.controller.testecontroller;

import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

public class Teste1 extends TestCase {

	public void before() {

		System.out.println("aqui");
		
	}

	public void teste() {

		String tradeXml = new RestTemplate().getForObject("http://localhost:8080/controlefinanceiro/teste/ping", String.class);
		assertEquals(0, tradeXml.indexOf("ping"));
		

	}

	
}
