package com.medeiros.ordnael.controlefinanceiro.resource.usuario;

import com.medeiros.ordnael.controlefinanceiro.model.Usuario;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class UsuarioResource extends ResourceCRUD<Usuario> {

	@Override
	public Class<Usuario> getModelClass() {
		return Usuario.class;
	}

}