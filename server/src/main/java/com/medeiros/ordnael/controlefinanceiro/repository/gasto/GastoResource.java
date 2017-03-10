package com.medeiros.ordnael.controlefinanceiro.repository.gasto;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Repository
public class GastoResource extends Resource<Gasto> {

	public GastoResource() {
		super(Gasto.class);
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		return null;
	}

}