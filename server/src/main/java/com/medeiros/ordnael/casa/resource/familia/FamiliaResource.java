package com.medeiros.ordnael.casa.resource.familia;

import com.medeiros.ordnael.casa.entity.Familia;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class FamiliaResource extends ResourceCRUD<Familia> {

	public FamiliaResource() {
	}
	
	public FamiliaResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Familia> getModelClass() {
		return Familia.class;
	}
	
}