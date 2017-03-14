package com.medeiros.ordnael.controlefinanceiro.repository.usuario;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Repository
public class UsuarioResource extends Resource<Usuario> {

	public UsuarioResource() {
		super(Usuario.class);
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		return null;
	}

}
