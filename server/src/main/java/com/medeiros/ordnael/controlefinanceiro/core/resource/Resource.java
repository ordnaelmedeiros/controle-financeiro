package com.medeiros.ordnael.controlefinanceiro.core.resource;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class Resource<Model> {

	protected abstract Map<String, Object> getFiltrosFixos();
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	private Class<Model> classe;
	private Long superId1;

	public EntityManager getEm() {
		return em;
	}
	public Long getSuperId1() {
		return superId1;
	}
	public void setSuperId1(Long superId1) {
		this.superId1 = superId1;
	}
	public Criteria createCriteria() {
		
		Session session = this.getEm().unwrap(org.hibernate.Session.class);
		return session.createCriteria(this.classe);
		
	}
	
	public Resource(Class<Model> classe) {
		this.classe = classe;
	}
	
	
	@Transactional
	public List<Model> findAll() throws Exception {

		List<Model> list = this.getEm().createQuery("SELECT c FROM "+this.getClasse().getSimpleName()+" c ORDER BY c.id ", getClasse()).getResultList();
		return list;

	}
	
	@Transactional
	public <T> List<T> findAll(Class<T> entityClass) throws Exception {

		List<T> list = this.getEm().createQuery("SELECT c FROM "+entityClass.getSimpleName()+" c ORDER BY c.id ", entityClass).getResultList();
		return list;

	}
	
	@Transactional
	public Model find(Long id) throws Exception {
		
		Model model = null;
		
		Map<String, Object> filtros = this.getFiltrosFixos();
		if (filtros!=null) {
			model = (Model) this.createCriteria().add(Restrictions.idEq(id)).add(Restrictions.allEq(filtros)).uniqueResult();
		} else {
			model = this.getEm().find(this.getClasse(), id);
		}
		return model;
	}
	
	@Transactional
	public <T> T find(Class<T> entityClass, Long id) throws Exception  {
		
		T model = null;
		
		Map<String, Object> filtros = this.getFiltrosFixos();
		if (filtros!=null) {
			model = (T) this.createCriteria().add(Restrictions.idEq(id)).add(Restrictions.allEq(filtros)).uniqueResult();
		} else {
			model = this.getEm().find(entityClass, id);
		}
		
		return model;
		
	}

	@Transactional
	public Model persist(Model model) throws Exception {
		this.getEm().persist(model);
		return model;
	}
	
	@Transactional
	public <T> T persist2(T entityClass) throws Exception  {
		this.getEm().persist(entityClass);
		return entityClass;
	}

	@Transactional
	public Model merge(Model model) throws Exception {
		this.getEm().merge(model);
		return model;
	}
	
	@Transactional
	public <T> T merge2(T entity) throws Exception {
		return this.getEm().merge(entity);
	}

	@Transactional
	public void remove(Long id) throws Exception {
		Model ent = this.find(id);
		this.getEm().remove(ent);
	}
	
	public Class<Model> getClasse() {
		return classe;
	}

	@SuppressWarnings("unchecked")
	public void setClasse(Class<?> classe) {
		this.classe = (Class<Model>)classe;
	}

}