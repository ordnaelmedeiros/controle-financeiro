package com.medeiros.ordnael.controlefinanceiro.repository.gasto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;

@Controller
@RequestMapping("/gasto")
public class GastoController extends ControllerCRUDObject<Gasto> {

	public GastoController() {
		super(Gasto.class);
	}
	
}
