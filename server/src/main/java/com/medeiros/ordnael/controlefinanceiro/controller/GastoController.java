package com.medeiros.ordnael.controlefinanceiro.controller;

import javax.ws.rs.Path;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/gasto")
public class GastoController extends Controller<Gasto> {
	
	public GastoController() {
		super(Gasto.class);
	}
	
}
