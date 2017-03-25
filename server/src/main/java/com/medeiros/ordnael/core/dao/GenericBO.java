package com.medeiros.ordnael.core.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class GenericBO implements AutoCloseable {
	
	private EntityManager em = null;
	
	public GenericBO() {
		 
	}
	

	public EntityManager getEm() {
		if (this.em==null) {
			this.em = EntityManagerUtil.getEntityManager();
		}
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Criteria createCriteria(Class<?> classe) {
		
		Session session = this.getEm().unwrap(org.hibernate.Session.class);
		return session.createCriteria(classe);
		
	}
	
	@Override
	public void close() throws Exception {
		if (this.em!=null) {
			this.em.close();
		}
	}

}
