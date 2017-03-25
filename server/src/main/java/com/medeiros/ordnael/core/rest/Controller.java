package com.medeiros.ordnael.core.rest;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.medeiros.ordnael.core.dao.GenericBO;

public class Controller<Model> {

	private Class<Model> modelClass;
	
	public Controller(Class<Model> modelClass) {
		this.modelClass = modelClass;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> get() throws Exception {

		try (GenericBO bo = new GenericBO()) {

			CriteriaBuilder builder = bo.getEm().getCriteriaBuilder();
			CriteriaQuery<Model> query = builder.createQuery(this.modelClass);
			query.select(query.from(this.modelClass));
			List<Model> lista = bo.getEm().createQuery(query).getResultList();

			return lista;

		} catch (Exception e) {
			throw e;
		}

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Model get(@PathParam("id") Long id) throws Exception {

		try (GenericBO bo = new GenericBO()) {

			Model usuario = bo.getEm().find(this.modelClass, id);
			return usuario;

		} catch (Exception e) {
			throw e;
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Model post(Model model) throws Exception {

		try (GenericBO bo = new GenericBO()) {

			bo.getEm().getTransaction().begin();
			bo.getEm().persist(model);
			bo.getEm().getTransaction().commit();
			return model;

		} catch (Exception e) {
			throw e;
		}

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Model put(Model model) throws Exception {
		
		try (GenericBO bo = new GenericBO()) {

			bo.getEm().getTransaction().begin();
			bo.getEm().merge(model);
			bo.getEm().getTransaction().commit();
			return model;

		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) throws Exception {
		
		try (GenericBO bo = new GenericBO()) {

			bo.getEm().getTransaction().begin();
			Model usuario = bo.getEm().find(this.modelClass, id);
			bo.getEm().remove(usuario);
			bo.getEm().getTransaction().commit();

			return Response.ok().build();
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
