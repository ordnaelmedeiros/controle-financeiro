package com.medeiros.ordnael.core.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.medeiros.ordnael.casa.model.Gasto;
import com.medeiros.ordnael.casa.model.Usuario;

public class ListaDeClassesTest {

	@Test
	public void testeClassesNoPacote() {
		
		try {
				
			String packageName = "com.medeiros.ordnael.casa.model";
			
			List<Class<?>> classes = new ListaDeClasses(packageName).getClasses();
			
			boolean temClassesUsuario = false;
			boolean temClassesGasto = false;
			
			for (Class<?> classe : classes) {
				if (Usuario.class.equals(classe)) {
					temClassesUsuario = true;
				} else if (Gasto.class.equals(classe)) {
					temClassesGasto = true;
				}
			}
			
			Assert.assertTrue(temClassesUsuario);
			Assert.assertTrue(temClassesGasto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
