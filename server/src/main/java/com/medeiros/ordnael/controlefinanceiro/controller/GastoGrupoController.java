package com.medeiros.ordnael.controlefinanceiro.controller;

import javax.ws.rs.Path;

import com.medeiros.ordnael.controlefinanceiro.model.GastoGrupo;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/gastogrupo")
public class GastoGrupoController extends Controller<GastoGrupo> {
	
	public GastoGrupoController() {
		super(GastoGrupo.class);
	}
	
}
