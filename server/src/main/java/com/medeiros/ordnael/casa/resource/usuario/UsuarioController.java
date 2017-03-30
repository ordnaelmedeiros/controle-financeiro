package com.medeiros.ordnael.casa.resource.usuario;

import javax.ws.rs.Path;

import com.medeiros.ordnael.casa.model.Usuario;
import com.medeiros.ordnael.core.rest.ControllerCRUD;

@Path("/usuario")
public class UsuarioController extends ControllerCRUD<Usuario, UsuarioResource> {

	@Override
	public UsuarioResource newResource() {
		return new UsuarioResource();
	}
	
}
