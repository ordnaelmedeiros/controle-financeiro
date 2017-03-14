package com.medeiros.ordnael.controlefinanceiro.repository.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;
import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends ControllerCRUDObject<Usuario> {

	@Autowired
	private UsuarioResource resource;
	
	public UsuarioController() {
		super(Usuario.class);
	}

	@Override
	protected Resource<Usuario> getResource() {
		return resource;
	}

}
