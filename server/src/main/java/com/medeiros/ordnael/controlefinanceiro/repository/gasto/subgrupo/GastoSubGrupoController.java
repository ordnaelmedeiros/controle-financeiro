package com.medeiros.ordnael.controlefinanceiro.repository.gasto.subgrupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medeiros.ordnael.controlefinanceiro.core.controller.ControllerCRUDObject;
import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

@Controller
@RequestMapping("/gasto/grupo/{superId1}/sub")
public class GastoSubGrupoController extends ControllerCRUDObject<GastoSubGrupo> {
	
	@Autowired
	private GastoSubGrupoResource resource;

	public GastoSubGrupoController() {
		super(GastoSubGrupo.class);
	}

	@Override
	protected Resource<GastoSubGrupo> getResource() {
		return resource;
	}
	
}
