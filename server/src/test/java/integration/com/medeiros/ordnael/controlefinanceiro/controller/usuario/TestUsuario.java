package integration.com.medeiros.ordnael.controlefinanceiro.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.repository.usuario.Usuario;

import junit.framework.TestCase;

public class TestUsuario extends TestCase {

	String url = "http://localhost:8080/controlefinanceiro/usuario";
	static RestTemplate restTemplate;
	ResponseEntity<Usuario> entity;
	
	static {
		
		restTemplate = new RestTemplate();
		
	}
	
	public void teste() {

		Usuario usuario = new Usuario();
		
		try {
			entity = restTemplate.postForEntity(url, usuario, Usuario.class);
			assertTrue("Devia dar erro", false);
		} catch (Exception e) {
			assertTrue("Deu erro", true);
		}
		
		
		
		
		/*
		Gasto gasto = new Gasto();
		gasto.setDescricao("Teste");
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
		
		Gasto gastoAlterado = entity.getBody();
		
		assertNotNull(gastoAlterado);
		assertNotNull(gastoAlterado.getId());
		assertEquals(gastoSalvo.getDescricao(), gastoAlterado.getDescricao());
		
		restTemplate.delete(url+"/{id}", gastoAlterado.getId());
		
		entity = restTemplate.getForEntity(url+"/{id}", Gasto.class, gastoSalvo.getId());
		assertNotNull(entity);
		assertNull(entity.getBody());
		*/
	}
	
}
