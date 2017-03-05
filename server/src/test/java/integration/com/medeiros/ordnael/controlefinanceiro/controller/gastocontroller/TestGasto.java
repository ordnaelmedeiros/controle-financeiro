package integration.com.medeiros.ordnael.controlefinanceiro.controller.gastocontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.repository.gasto.Gasto;

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
		/*
		GastoGrupo grupo = new GastoGrupo();
		grupo.setId(1l);
		gasto.setGastoGrupo(grupo);
		
		//gasto.setGastoGrupoId(1l);
		*/
		entity = restTemplate.postForEntity(url, gasto, Gasto.class);
		
		assertNotNull(entity);
		
		Gasto gastoSalvo = entity.getBody();
		
		assertNotNull(gastoSalvo);
		assertNotNull(gastoSalvo.getId());
		assertEquals(gasto.getDescricao(), gastoSalvo.getDescricao());
		
		gastoSalvo.setDescricao(gastoSalvo.getDescricao() + " 11");
		
		restTemplate.put(url, gastoSalvo);
		
		entity = restTemplate.getForEntity(url+"/{id}", Gasto.class, gastoSalvo.getId());
		assertNotNull(entity);
		
		Gasto gastoAnterado = entity.getBody();
		
		assertNotNull(gastoAnterado);
		assertNotNull(gastoAnterado.getId());
		assertEquals(gastoSalvo.getDescricao(), gastoAnterado.getDescricao());
		
		restTemplate.delete(url+"/{id}", gastoAnterado.getId());
		
		entity = restTemplate.getForEntity(url+"/{id}", Gasto.class, gastoSalvo.getId());
		assertNotNull(entity);
		assertNull(entity.getBody());
		
	}
	
}
