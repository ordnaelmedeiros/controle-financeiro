package com.medeiros.ordnael.casa.resource.familia;

import javax.ws.rs.Path;

import com.medeiros.ordnael.casa.entity.Familia;
import com.medeiros.ordnael.core.rest.ControllerCRUD;

@Path("/familia")
public class FamiliaController extends ControllerCRUD<Familia, FamiliaResource> {

	@Override
	public FamiliaResource newResource() {
		return new FamiliaResource();
	}
	
}
