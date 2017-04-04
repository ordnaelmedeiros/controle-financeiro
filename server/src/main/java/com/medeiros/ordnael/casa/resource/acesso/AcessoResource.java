package com.medeiros.ordnael.casa.resource.acesso;

import javax.persistence.TypedQuery;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.core.resource.ResourceCRUD;

public class AcessoResource extends ResourceCRUD<Acesso> {

	public AcessoResource() {
	}
	
	public AcessoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Acesso> getModelClass() {
		return Acesso.class;
	}

	public Acesso buscaPorNomeDeAcesso(String nomeacesso) {
		
		nomeacesso = nomeacesso.trim().toLowerCase();
		
		TypedQuery<Acesso> query = this.getEm().createQuery("select a from Acesso a where a.nomeacesso = :nomeacesso", this.getModelClass());
		query.setParameter("nomeacesso", nomeacesso);
		Acesso acesso = query.getSingleResult();
		return acesso;
		
	}

	public Acesso buscaPorToken(String token) {
		
		TypedQuery<Acesso> query = this.getEm().createQuery("select a from Acesso a where a.token = :token", this.getModelClass());
		query.setParameter("token", token);
		Acesso acesso = query.getSingleResult();
		
		return acesso;
	}

}
