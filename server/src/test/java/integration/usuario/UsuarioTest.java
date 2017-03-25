package integration.usuario;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import com.medeiros.ordnael.controlefinanceiro.model.Usuario;

public class UsuarioTest {
	
	private final String url = "http://localhost:8080/controlefinanceiro/rest/usuario";

	
	@Test
	public void crudTest() {
		
		//gravar
		Usuario usuSalvar = new Usuario();
		usuSalvar.setNomeacesso("teste");
		usuSalvar.setEmail("teste@teste.com");
		usuSalvar.setSenha("123456");
		
		Usuario usuSalvo = ClientBuilder.newClient().target(url).request().post(Entity.entity(usuSalvar, MediaType.APPLICATION_JSON), Usuario.class);
		Assert.assertNotNull(usuSalvo);
		Assert.assertNotNull(usuSalvo.getId());
		Assert.assertEquals(usuSalvar.getNomeacesso(), usuSalvo.getNomeacesso());
		Assert.assertEquals(usuSalvar.getEmail(), usuSalvo.getEmail());
		Assert.assertEquals(usuSalvar.getSenha(), usuSalvo.getSenha());

		Usuario usuSalvo2 = ClientBuilder.newClient().target(url).path("/{id}").resolveTemplate("id", usuSalvo.getId()).request().get(Usuario.class);
		Assert.assertNotNull(usuSalvo2);
		Assert.assertEquals(usuSalvo2.getId(), usuSalvo.getId());
		Assert.assertEquals(usuSalvo2.getNomeacesso(), usuSalvo.getNomeacesso());
		Assert.assertEquals(usuSalvo2.getEmail(), usuSalvo.getEmail());
		Assert.assertEquals(usuSalvo2.getSenha(), usuSalvo.getSenha());

		//alterar
		usuSalvo.setNomeacesso("teste2");
		Usuario usuAlterado = ClientBuilder.newClient().target(url).request().put(Entity.entity(usuSalvo, MediaType.APPLICATION_JSON), Usuario.class);
		Assert.assertNotNull(usuAlterado);
		Assert.assertEquals(usuAlterado.getId(), usuSalvo.getId());
		Assert.assertEquals(usuAlterado.getNomeacesso(), usuSalvo.getNomeacesso());
		Assert.assertEquals(usuAlterado.getEmail(), usuSalvo.getEmail());
		Assert.assertEquals(usuAlterado.getSenha(), usuSalvo.getSenha());

		//remover
		Response response = ClientBuilder.newClient().target(url).path("/{id}").resolveTemplate("id", usuAlterado.getId()).request().delete();
		Assert.assertEquals("Usuário removido.", Response.ok().build().getStatus(), response.getStatus());
		
		Usuario obj = ClientBuilder.newClient().target(url).path("/{id}").resolveTemplate("id", usuAlterado.getId()).request().get(Usuario.class);
		Assert.assertNull(obj);
		
	}
	
}
