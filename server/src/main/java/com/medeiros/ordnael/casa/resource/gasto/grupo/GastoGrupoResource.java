package com.medeiros.ordnael.casa.resource.gasto.grupo;

import com.medeiros.ordnael.casa.model.GastoGrupo;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class GastoGrupoResource extends ResourceCRUD<GastoGrupo> {

	public GastoGrupoResource() {
	}
	
	public GastoGrupoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<GastoGrupo> getModelClass() {
		return GastoGrupo.class;
	}

}
