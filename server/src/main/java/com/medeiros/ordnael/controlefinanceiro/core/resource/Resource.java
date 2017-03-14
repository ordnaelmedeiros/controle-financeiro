package com.medeiros.ordnael.controlefinanceiro.core.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.controlefinanceiro.core.validacao.Validacao;
import com.medeiros.ordnael.controlefinanceiro.core.validacao.impl.ValidacaoCampoObrigatorio;

@SuppressWarnings("unchecked")
public abstract class Resource<Model> {
	
	private List<Validacao<Model>> validPersist = new ArrayList<>();
	private List<Validacao<Model>> validPersistMerge = new ArrayList<>();
	private List<Validacao<Model>> validMerge = new ArrayList<>();
	private List<Validacao<Model>> validRemove = new ArrayList<>();
	
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
		this.addValidPersistMerge(new ValidacaoCampoObrigatorio<Model>());
	}
	
	@Transactional
	public List<Model> findAll() throws Exception {

		List<Model> lista = null;
		
		Map<String, Object> filtros = this.getFiltrosFixos();
		
		Criteria cri = this.createCriteria();
		if (filtros!=null) {
			cri.add(Restrictions.allEq(filtros));
		}
		cri.addOrder(Order.asc("id"));
		
		lista = cri.list();
		
		return lista;

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
	public Model persist(Model model) throws Exception {
		for (Validacao<Model> validador : validPersist) {
			validador.validar(this, model);
		}
		for (Validacao<Model> validador : validPersistMerge) {
			validador.validar(this, model);
		}
		this.atualizaSuperIds(model);
		this.getEm().persist(model);
		return model;
	}
	
	@Transactional
	public Model merge(Model model) throws Exception {
		for (Validacao<Model> validador : validMerge) {
			validador.validar(this, model);
		}
		for (Validacao<Model> validador : validPersistMerge) {
			validador.validar(this, model);
		}
		this.atualizaSuperIds(model);
		this.getEm().merge(model);
		return model;
	}
	
	@Transactional
	public void remove(Long id) throws Exception {
		Model model = this.find(id);
		for (Validacao<Model> validador : validRemove) {
			validador.validar(this, model);
		}
		this.getEm().remove(model);
	}
	
	public Class<Model> getClasse() {
		return classe;
	}

	public void setClasse(Class<?> classe) {
		this.classe = (Class<Model>)classe;
	}
	
	protected void atualizaSuperIds(Model entity) throws Exception {
		
	}
	
	protected void addValidPersist(Validacao<Model> val) {
		this.validPersist.add(val);
	}
	
	protected void addValidMerge(Validacao<Model> val) {
		this.validMerge.add(val);
	}

	protected void addValidPersistMerge(Validacao<Model> val) {
		this.validPersistMerge.add(val);
	}
	
	protected void addValidRemove(Validacao<Model> val) {
		this.validRemove.add(val);
	}
	
}
