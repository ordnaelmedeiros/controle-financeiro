package com.medeiros.ordnael.controlefinanceiro.repository.gasto.subgrupo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Repository
public class GastoSubGrupoResource extends Resource<GastoSubGrupo> {

	public GastoSubGrupoResource() {
		super(GastoSubGrupo.class);
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		Map<String, Object> filtros = new HashMap<>();
		filtros.put("gastoGrupoId", this.getSuperId1());
		return filtros;
	}

}