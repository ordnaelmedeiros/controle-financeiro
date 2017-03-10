package com.medeiros.ordnael.controlefinanceiro.repository.gasto.grupo;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Repository
public class GastoGrupoResource extends Resource<GastoGrupo> {

	public GastoGrupoResource() {
		super(GastoGrupo.class);
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		return null;
	}

}