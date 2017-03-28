package com.medeiros.ordnael.controlefinanceiro.resource.gasto.subgrupo;

import java.util.ArrayList;
import java.util.List;

import com.medeiros.ordnael.controlefinanceiro.model.GastoGrupo;
import com.medeiros.ordnael.controlefinanceiro.model.GastoSubGrupo;
import com.medeiros.ordnael.controlefinanceiro.resource.gasto.grupo.GastoGrupoResource;
import com.medeiros.ordnael.core.resource.ResourceCRUD;
import com.medeiros.ordnael.core.rest.Filtro;

public class GastoSubGrupoResource extends ResourceCRUD<GastoSubGrupo> {

	private Long gastoGrupoId;
	
	public GastoSubGrupoResource(Long gastoGrupoId) {
		this.gastoGrupoId = gastoGrupoId;
	}
	
	@Override
	public Class<GastoSubGrupo> getModelClass() {
		return GastoSubGrupo.class;
	}

	@SuppressWarnings("resource")
	@Override
	protected List<Filtro> getFiltros(ResourceCRUD<GastoSubGrupo> res) {
		
		GastoGrupoResource gastoGrupoResource = new GastoGrupoResource(res);
		GastoGrupo gastoGrupo = gastoGrupoResource.busca(this.gastoGrupoId);
		
		List<Filtro> filtros = new ArrayList<>();
		filtros.add(new Filtro("gastoGrupo", gastoGrupo));
		return filtros;
		
	}
	
}
