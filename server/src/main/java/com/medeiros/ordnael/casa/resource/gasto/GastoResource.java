package com.medeiros.ordnael.casa.resource.gasto;

import com.medeiros.ordnael.casa.model.Gasto;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class GastoResource extends ResourceCRUD<Gasto> {

	@Override
	public Class<Gasto> getModelClass() {
		return Gasto.class;
	}

}
