package com.medeiros.ordnael.controlefinanceiro.resource.gasto;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class GastoResource extends ResourceCRUD<Gasto> {

	@Override
	public Class<Gasto> getModelClass() {
		return Gasto.class;
	}

}
