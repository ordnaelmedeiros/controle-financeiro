package com.medeiros.ordnael.casa.resource.usuario;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.medeiros.ordnael.casa.entity.Usuario;
import com.medeiros.ordnael.core.rest.ControllerCRUD;

@Path("/usuario")
public class UsuarioController extends ControllerCRUD<Usuario, UsuarioResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@Override
	public UsuarioResource newResource() {
		return new UsuarioResource();
	}
	
	//@HeaderParam("usertoken") String usertoken
	
	@GET
	@Path("/token")
	public Usuario getUsuarioByToken() throws Exception {
		
		try (UsuarioResource res = new UsuarioResource()) {
			
			return res.buscarPeloToken(this.userToken);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
