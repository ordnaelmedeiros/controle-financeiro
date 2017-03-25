package com.medeiros.ordnael.controlefinanceiro.controller;

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

import com.medeiros.ordnael.controlefinanceiro.model.Usuario;
import com.medeiros.ordnael.core.dao.GenericBO;

@Path("/usuario")
public class UsuarioController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> get() throws Exception {

		try (GenericBO bo = new GenericBO()) {

			CriteriaBuilder builder = bo.getEm().getCriteriaBuilder();
			CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
			query.select(query.from(Usuario.class));
			List<Usuario> lista = bo.getEm().createQuery(query).getResultList();

			return lista;

		} catch (Exception e) {
			throw e;
		}

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario get(@PathParam("id") Long id) throws Exception {

		try (GenericBO bo = new GenericBO()) {

			Usuario usuario = bo.getEm().find(Usuario.class, id);
			return usuario;

		} catch (Exception e) {
			throw e;
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario post(Usuario usuario) throws Exception {

		try (GenericBO bo = new GenericBO()) {

			bo.getEm().getTransaction().begin();
			bo.getEm().persist(usuario);
			bo.getEm().getTransaction().commit();
			return usuario;

		} catch (Exception e) {
			throw e;
		}

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario put(Usuario usuario) throws Exception {
		
		try (GenericBO bo = new GenericBO()) {

			bo.getEm().getTransaction().begin();
			bo.getEm().merge(usuario);
			bo.getEm().getTransaction().commit();
			return usuario;

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
			Usuario usuario = bo.getEm().find(Usuario.class, id);
			bo.getEm().remove(usuario);
			bo.getEm().getTransaction().commit();

			return Response.ok().build();
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	

}
