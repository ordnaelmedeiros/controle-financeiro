package com.medeiros.ordnael.controlefinanceiro.resource.usuario;

import javax.ws.rs.Path;

import com.medeiros.ordnael.controlefinanceiro.model.Usuario;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/usuario")
public class UsuarioController extends Controller<Usuario, UsuarioResource> {

	@Override
	public UsuarioResource newResource() {
		return new UsuarioResource();
	}
	
}
