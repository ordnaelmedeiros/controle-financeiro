package integration.com.medeiros.ordnael.controlefinanceiro.controller.testecontroller;



import java.math.BigDecimal;
import java.time.LocalDate;

import com.medeiros.ordnael.controlefinanceiro.core.WebApiRest;
import com.medeiros.ordnael.controlefinanceiro.model.ObjetoTeste;

import junit.framework.TestCase;


public class Test extends TestCase {
	

	public void testGetPing() {
		
		
	    String tradeXml = new WebApiRest().get("teste/ping", String.class);
		assertEquals(0, tradeXml.indexOf("ping"));
		
	}
	
	public void testGetObjeto() {
		
		ObjetoTeste obj1 = new ObjetoTeste();
		obj1.criar();
		
		ObjetoTeste obj2 = new WebApiRest().get("teste/objeto", ObjetoTeste.class);
		assertNotNull(obj2);
		assertObjetoTeste(obj1, obj2);
		
	}
	
	public void testPostObjeto() {
		
		ObjetoTeste obj1 = new ObjetoTeste();
		obj1.criar();
		
		ObjetoTeste obj2 = new WebApiRest().post("teste/objeto", obj1, ObjetoTeste.class);
		assertNotNull(obj2);
		assertObjetoTeste(obj1, obj2);
		
	}

	private void assertObjetoTeste(ObjetoTeste obj1, ObjetoTeste obj2) {
		assertEquals("Campo Integer diferente", obj1.getvInteger(), obj2.getvInteger());
		assertEquals("Campo Long diferente", obj1.getvLong(), obj2.getvLong());
		assertEquals("Campo Booelan diferente", obj1.getvBooleanTrue(), obj2.getvBooleanTrue());
		assertEquals("Campo Booelan diferente", obj1.getvBooleanFalse(), obj2.getvBooleanFalse());
		assertEquals("Campo Double diferente", obj1.getvDouble(), obj2.getvDouble());
		assertEquals("Campo Float diferente", obj1.getvFloat(), obj2.getvFloat());
		assertEquals("Campo BigDecimal diferente", obj1.getvBigDecimal(), obj2.getvBigDecimal());
		assertEquals("Campo String diferente", obj1.getvString(), obj2.getvString());
	}
	
	
	
}
