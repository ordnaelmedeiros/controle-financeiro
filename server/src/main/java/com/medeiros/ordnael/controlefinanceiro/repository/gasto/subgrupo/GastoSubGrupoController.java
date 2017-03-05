package com.medeiros.ordnael.controlefinanceiro.repository.gasto.subgrupo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;

@Controller
@RequestMapping("/gastosubgrupo")
public class GastoSubGrupoController extends ControllerCRUDObject<GastoSubGrupo> {

	public GastoSubGrupoController() {
		super(GastoSubGrupo.class);
	}
	
}
