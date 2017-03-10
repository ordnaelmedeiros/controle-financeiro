package com.medeiros.ordnael.controlefinanceiro.repository.gasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;
import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Controller
@RequestMapping("/gasto")
public class GastoController extends ControllerCRUDObject<Gasto> {

	@Autowired
	private GastoResource resource;

	@Override
	protected Resource<Gasto> getResource() {
		return resource;
	}
	
	public GastoController() {
		super(Gasto.class);
	}
	
}
