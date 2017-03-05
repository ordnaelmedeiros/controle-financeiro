package com.medeiros.ordnael.controlefinanceiro.repository.gasto.grupo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;

@Controller
@RequestMapping("/gastogrupo")
public class GastoGrupoController extends ControllerCRUDObject<GastoGrupo> {

	public GastoGrupoController() {
		super(GastoGrupo.class);
	}
	
}
