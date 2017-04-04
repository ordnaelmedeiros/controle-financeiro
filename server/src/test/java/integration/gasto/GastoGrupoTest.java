package integration.gasto;

import org.junit.Assert;

import com.medeiros.ordnael.casa.entity.GastoSubGrupo;

import integration.TesteCrud;

public class GastoGrupoTest extends TesteCrud<GastoSubGrupo> {

	@Override
	protected String getUrlName() {
		return "gasto/grupo/1/sub";
	}
	
	@Override
	protected Class<GastoSubGrupo> getModelClass() {
		return GastoSubGrupo.class;
	}

	@Override
	protected Long getId(GastoSubGrupo obj) {
		return obj.getId();
	}
	
	@Override
	protected void assertCompara(GastoSubGrupo obj1, GastoSubGrupo obj2) {
		Assert.assertEquals(obj1.getSigla(), obj2.getSigla());
		Assert.assertEquals(obj1.getDescricao(), obj2.getDescricao());
	}

	@Override
	protected GastoSubGrupo getObjGravar() {
		GastoSubGrupo obj = new GastoSubGrupo();
		obj.setDescricao("Teste");
		obj.setSigla("TE");
		return obj;
	}

	@Override
	protected void alterarObjeto(GastoSubGrupo obj) {
		obj.setDescricao("Teste 2");
	}

}
