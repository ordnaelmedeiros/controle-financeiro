package com.medeiros.ordnael.casa.resource.gasto.grupo;

import javax.ws.rs.Path;

import com.medeiros.ordnael.casa.entity.GastoGrupo;
import com.medeiros.ordnael.core.rest.ControllerCRUD;

@Path("/gasto/grupo")
public class GastoGrupoController extends ControllerCRUD<GastoGrupo, GastoGrupoResource> {

	@Override
	public GastoGrupoResource newResource() {
		return new GastoGrupoResource();
	}
	
}
