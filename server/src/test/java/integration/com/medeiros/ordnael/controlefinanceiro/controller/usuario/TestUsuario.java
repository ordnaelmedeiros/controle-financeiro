package integration.com.medeiros.ordnael.controlefinanceiro.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.core.validacao.impl.ValidacaoCampoObrigatorio;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.Usuario;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioEmailUnico;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioNomeAcessoUnico;

import junit.framework.TestCase;

public class TestUsuario extends TestCase {

	String url = "http://localhost:8080/controlefinanceiro/usuario";
	static RestTemplate restTemplate;
	ResponseEntity<Usuario> entity;
	
	static {
		
		restTemplate = new RestTemplate();
		
	}
	
	private Usuario createUsuarioValido() {
		
		Usuario usuario = new Usuario();
		usuario.setNomeacesso("teste");
		usuario.setEmail("teste@gmail.com");
		usuario.setSenha("123456");
		
		return usuario;
		
	}
	
	public void teste() {

		Usuario usuario = this.createUsuarioValido();
		usuario.setNomeacesso(null);
		
		try {
			entity = restTemplate.postForEntity(url, usuario, Usuario.class);
			assertEquals(new ValidacaoCampoObrigatorio<>().getMensagem(), "sucesso");
		} catch (HttpServerErrorException e) {
			assertEquals(new ValidacaoCampoObrigatorio<>().getMensagem()+"Nome de Acesso", e.getResponseBodyAsString());
		} catch (Exception e) {
			assertTrue("Deu erro", true);
		}
		
		
		usuario = this.createUsuarioValido();
		usuario.setEmail(null);
		
		try {
			entity = restTemplate.postForEntity(url, usuario, Usuario.class);
			assertEquals(new ValidacaoCampoObrigatorio<>().getMensagem(), "sucesso");
		} catch (HttpServerErrorException e) {
			assertEquals(new ValidacaoCampoObrigatorio<>().getMensagem()+"Email", e.getResponseBodyAsString());
		} catch (Exception e) {
			assertTrue("Deu erro", true);
		}
		
		
		usuario = this.createUsuarioValido();
		usuario.setNomeacesso("leandro");
		
		try {
			entity = restTemplate.postForEntity(url, usuario, Usuario.class);
			assertEquals(new UsuarioNomeAcessoUnico().getMensagem(), "sucesso");
		} catch (HttpServerErrorException e) {
			assertEquals(new UsuarioNomeAcessoUnico().getMensagem(), e.getResponseBodyAsString());
		} catch (Exception e) {
			assertTrue("Deu erro", true);
		}
		
		
		usuario = this.createUsuarioValido();
		usuario.setEmail("ordnaelmedeiros@gmail.com");
		
		try {
			entity = restTemplate.postForEntity(url, usuario, Usuario.class);
			assertEquals(new UsuarioNomeAcessoUnico().getMensagem(), "sucesso");
		} catch (HttpServerErrorException e) {
			assertEquals(new UsuarioEmailUnico().getMensagem(), e.getResponseBodyAsString());
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
