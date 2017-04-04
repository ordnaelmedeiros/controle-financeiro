package integration.gasto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;

import com.medeiros.ordnael.casa.entity.Gasto;

import integration.TesteCrud;

public class GastoTest extends TesteCrud<Gasto> {

	@Override
	protected String getUrlName() {
		return "gasto";
	}
	
	@Override
	protected Class<Gasto> getModelClass() {
		return Gasto.class;
	}

	@Override
	protected Long getId(Gasto obj) {
		return obj.getId();
	}
	
	@Override
	protected void assertCompara(Gasto obj1, Gasto obj2) {
		Assert.assertEquals(obj1.getDescricao(), obj2.getDescricao());
		Assert.assertEquals(obj1.getData(), obj2.getData());
		//Assert.assertEquals(obj1.getValor(), obj2.getValor());
		if (obj1.getValor()==null) {
			Assert.assertNull(obj2.getValor());
		} else {
			Assert.assertTrue(obj1.getValor().compareTo(obj2.getValor())==0);
		}
		Assert.assertEquals(obj1.getGastoGrupoId(), obj2.getGastoGrupoId());
		Assert.assertEquals(obj1.getGastoSubGrupoId(), obj2.getGastoSubGrupoId());
	}

	@Override
	protected Gasto getObjGravar() {
		Gasto obj = new Gasto();
		obj.setDescricao("Teste");
		obj.setData(LocalDate.now());
		obj.setValor(BigDecimal.TEN);
		return obj;
	}

	@Override
	protected void alterarObjeto(Gasto obj) {
		obj.setDescricao("Teste 2");
	}

}
