package com.medeiros.ordnael.core.rest;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.medeiros.ordnael.core.resource.ResourceCRUD;

public abstract class Controller<Model, R extends ResourceCRUD<Model>> {

	public abstract R newResource();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> get() throws Exception {
		try (R res = this.newResource()) {
			return res.buscaTotos();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Model get(@PathParam("id") Long id) throws Exception {
		try (R res = this.newResource()) {
			Model usuario = res.busca(id);
			return usuario;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Model post(Model model) throws Exception {
		try (R res = this.newResource()) {
			res.gravar(model);
			return model;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Model put(Model model) throws Exception {
		try (R res = this.newResource()) {
			res.alterar(model);
			return model;
		} catch (Exception e) {
			throw e;
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) throws Exception {
		try (R res = this.newResource()) {
			res.remover(id);
			return Response.ok().build();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
