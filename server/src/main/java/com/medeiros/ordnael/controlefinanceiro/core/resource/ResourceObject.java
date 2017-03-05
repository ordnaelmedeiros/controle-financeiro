package com.medeiros.ordnael.controlefinanceiro.core.resource;

import org.springframework.stereotype.Repository;

@Repository
public class ResourceObject extends Resource<Object> {

	public ResourceObject() {
		super(Object.class);
	}
	
}
