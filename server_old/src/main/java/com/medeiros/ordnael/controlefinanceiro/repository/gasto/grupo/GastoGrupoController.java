package com.medeiros.ordnael.controlefinanceiro.repository.gasto.grupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;
import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Controller
@RequestMapping("/gasto/grupo")
public class GastoGrupoController extends ControllerCRUDObject<GastoGrupo> {

	@Autowired
	private GastoGrupoResource resource;

	@Override
	protected Resource<GastoGrupo> getResource() {
		return resource;
	}
	
	public GastoGrupoController() {
		super(GastoGrupo.class);
	}
	
}
