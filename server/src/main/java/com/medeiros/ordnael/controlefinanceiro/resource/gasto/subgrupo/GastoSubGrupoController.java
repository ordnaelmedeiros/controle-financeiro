package com.medeiros.ordnael.controlefinanceiro.resource.gasto.subgrupo;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.medeiros.ordnael.controlefinanceiro.model.GastoSubGrupo;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/gasto/grupo/{gastoGrupoId}/sub")
public class GastoSubGrupoController extends Controller<GastoSubGrupo, GastoSubGrupoResource> {
	
	@PathParam("gastoGrupoId")
	private Long gastoGrupoId;
	
	@Override
	public GastoSubGrupoResource newResource() {
		return new GastoSubGrupoResource(this.gastoGrupoId);
	}
	
}