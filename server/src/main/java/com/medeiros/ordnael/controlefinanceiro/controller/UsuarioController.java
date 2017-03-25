package com.medeiros.ordnael.controlefinanceiro.controller;

import javax.ws.rs.Path;

import com.medeiros.ordnael.controlefinanceiro.model.Usuario;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/usuario")
public class UsuarioController extends Controller<Usuario> {
	
	public UsuarioController() {
		super(Usuario.class);
	}
	
}
