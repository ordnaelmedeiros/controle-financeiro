package com.medeiros.ordnael.casa.resource.usuario;

import com.medeiros.ordnael.casa.model.Usuario;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class UsuarioResource extends ResourceCRUD<Usuario> {

	@Override
	public Class<Usuario> getModelClass() {
		return Usuario.class;
	}

}