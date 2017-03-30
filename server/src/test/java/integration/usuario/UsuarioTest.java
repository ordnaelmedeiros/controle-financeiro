package integration.usuario;

import org.junit.Assert;

import com.medeiros.ordnael.casa.model.Usuario;

import integration.TesteCrud;

public class UsuarioTest extends TesteCrud<Usuario> {

	@Override
	protected String getUrlName() {
		return "usuario";
	}
	
	@Override
	protected Class<Usuario> getModelClass() {
		return Usuario.class;
	}

	@Override
	protected Long getId(Usuario obj) {
		return obj.getId();
	}
	
	@Override
	protected void assertCompara(Usuario obj1, Usuario obj2) {
		Assert.assertEquals(obj1.getNomeacesso(), obj2.getNomeacesso());
		Assert.assertEquals(obj1.getEmail(), obj2.getEmail());
		Assert.assertEquals(obj1.getSenha(), obj2.getSenha());
	}

	@Override
	protected Usuario getObjGravar() {
		Usuario usuSalvar = new Usuario();
		usuSalvar.setNomeacesso("teste");
		usuSalvar.setEmail("teste@teste.com");
		usuSalvar.setSenha("123456");
		return usuSalvar;
	}

	@Override
	protected void alterarObjeto(Usuario obj) {
		obj.setNomeacesso("teste2");
	}

}
