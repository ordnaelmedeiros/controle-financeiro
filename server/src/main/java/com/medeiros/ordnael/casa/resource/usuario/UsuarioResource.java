package com.medeiros.ordnael.casa.resource.usuario;

import javax.persistence.TypedQuery;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Usuario;
import com.medeiros.ordnael.casa.resource.acesso.AcessoResource;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class UsuarioResource extends ResourceCRUD<Usuario> {

	public UsuarioResource() {
	}
	
	public UsuarioResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Usuario> getModelClass() {
		return Usuario.class;
	}
	
	public Usuario buscarPeloToken(String token) {
		
		@SuppressWarnings("resource")
		AcessoResource res = new AcessoResource(this);
		Acesso acesso = res.buscaPorToken(token);
		
		TypedQuery<Usuario> query = this.getEm().createQuery("select u from Usuario u where u.acesso = :acesso", this.getModelClass());
		query.setParameter("acesso", acesso);
		Usuario usu = query.getSingleResult();
		
		return usu;
		
	}
	
	public Usuario buscarPeloAcesso(Acesso acesso) {
		
		TypedQuery<Usuario> query = this.getEm().createQuery("select u from Usuario u where u.acesso = :acesso", this.getModelClass());
		query.setParameter("acesso", acesso);
		Usuario usu = query.getSingleResult();
		
		return usu;
		
	}

}