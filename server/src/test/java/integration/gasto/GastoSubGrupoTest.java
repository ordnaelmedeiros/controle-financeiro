package integration.gasto;

import org.junit.Assert;

import com.medeiros.ordnael.casa.model.GastoGrupo;

import integration.TesteCrud;

public class GastoSubGrupoTest extends TesteCrud<GastoGrupo> {

	@Override
	protected String getUrlName() {
		return "gasto/grupo";
	}
	
	@Override
	protected Class<GastoGrupo> getModelClass() {
		return GastoGrupo.class;
	}

	@Override
	protected Long getId(GastoGrupo obj) {
		return obj.getId();
	}
	
	@Override
	protected void assertCompara(GastoGrupo obj1, GastoGrupo obj2) {
		Assert.assertEquals(obj1.getSigla(), obj2.getSigla());
		Assert.assertEquals(obj1.getDescricao(), obj2.getDescricao());
	}

	@Override
	protected GastoGrupo getObjGravar() {
		GastoGrupo obj = new GastoGrupo();
		obj.setDescricao("Teste");
		obj.setSigla("TE");
		return obj;
	}

	@Override
	protected void alterarObjeto(GastoGrupo obj) {
		obj.setDescricao("Teste 2");
	}

}
