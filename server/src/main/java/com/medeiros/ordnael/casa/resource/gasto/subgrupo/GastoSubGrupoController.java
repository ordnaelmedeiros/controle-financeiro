package com.medeiros.ordnael.casa.resource.gasto.subgrupo;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.medeiros.ordnael.casa.entity.GastoSubGrupo;
import com.medeiros.ordnael.core.rest.ControllerCRUD;

@Path("/gasto/grupo/{gastoGrupoId}/sub")
public class GastoSubGrupoController extends ControllerCRUD<GastoSubGrupo, GastoSubGrupoResource> {
	
	@PathParam("gastoGrupoId")
	private Long gastoGrupoId;
	
	@Override
	public GastoSubGrupoResource newResource() {
		return new GastoSubGrupoResource(this.gastoGrupoId);
	}
	
}