package com.medeiros.ordnael.controlefinanceiro.resource.gasto;

import javax.ws.rs.Path;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;
import com.medeiros.ordnael.core.rest.Controller;

@Path("/gasto")
public class GastoController extends Controller<Gasto, GastoResource> {
	
	@Override
	public GastoResource newResource() {
		return new GastoResource();
	}
	
}