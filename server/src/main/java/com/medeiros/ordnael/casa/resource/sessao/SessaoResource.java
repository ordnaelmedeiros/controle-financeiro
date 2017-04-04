package com.medeiros.ordnael.casa.resource.sessao;

import com.medeiros.ordnael.casa.entity.Sessao;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class SessaoResource extends ResourceCRUD<Sessao> {

	public SessaoResource() {
	}
	
	public SessaoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Sessao> getModelClass() {
		return Sessao.class;
	}

}
