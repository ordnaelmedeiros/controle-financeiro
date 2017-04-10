package com.medeiros.ordnael.casa.resource.sessao;

import javax.persistence.TypedQuery;

import com.medeiros.ordnael.casa.entity.Sessao;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class SessaoResource extends ResourceCRUD<Sessao> {

	public SessaoResource() {
	}
	
	public SessaoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Sessao> getModelClass() {
		return Sessao.class;
	}
	
	public Sessao buscaPelaToken(String token) {
		
		TypedQuery<Sessao> query = this.getEm().createQuery("select u from Sessao u where u.token = :token", this.getModelClass());
		query.setParameter("token", token);
		Sessao sessao = query.getSingleResult();
		
		return sessao;
		
	}

}
