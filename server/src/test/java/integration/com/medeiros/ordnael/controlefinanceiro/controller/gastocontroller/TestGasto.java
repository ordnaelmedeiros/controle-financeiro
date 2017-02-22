package integration.com.medeiros.ordnael.controlefinanceiro.controller.gastocontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;

import junit.framework.TestCase;

public class TestGasto extends TestCase {

	String url = "http://localhost:8080/controlefinanceiro/gasto";
	static RestTemplate restTemplate;
	ResponseEntity<Gasto> entity;
	
	static {
		
		restTemplate = new RestTemplate();
		
	}
	
	public void teste() {

		Gasto gasto = new Gasto();
		gasto.setDescricao("Teste");
		
		entity = restTemplate.postForEntity(url, gasto, Gasto.class);
		
		assertNotNull(entity);
		
		Gasto gastoSalvo = entity.getBody();
		
		assertNotNull(gastoSalvo);
		assertNotNull(gastoSalvo.getGastoId());
		assertEquals(gasto.getDescricao(), gastoSalvo.getDescricao());
		
		gastoSalvo.setDescricao(gastoSalvo.getDescricao() + " 11");
		
		restTemplate.put(url, gastoSalvo);
		
		entity = restTemplate.getForEntity(url+"/{id}", Gasto.class, gastoSalvo.getGastoId());
		assertNotNull(entity);
		
		Gasto gastoAnterado = entity.getBody();
		
		assertNotNull(gastoAnterado);
		assertNotNull(gastoAnterado.getGastoId());
		assertEquals(gastoSalvo.getDescricao(), gastoAnterado.getDescricao());
		
		restTemplate.delete(url+"/{id}", gastoAnterado.getGastoId());
		
		entity = restTemplate.getForEntity(url+"/{id}", Gasto.class, gastoSalvo.getGastoId());
		assertNotNull(entity);
		assertNull(entity.getBody());
		
	}
	
}
