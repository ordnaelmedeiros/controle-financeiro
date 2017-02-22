package com.medeiros.ordnael.controlefinanceiro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;

@Repository
public class GastoRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@Transactional
	public void Salvar(Gasto gasto) {

		manager.persist(gasto);
		
	}

	@Transactional
	public void Alterar(Gasto gasto) {

		manager.merge(gasto);
	}

	@Transactional
	public void Excluir(Long codigo) {

		Gasto gasto = this.ConsultarPorCodigo(codigo);
		manager.remove(gasto);

	}

	public Gasto ConsultarPorCodigo(Long codigo) {

		return manager.find(Gasto.class, codigo);
		
	}
	
	public List<Gasto> TodosUsuarios() {
		
		return manager.createQuery("SELECT c FROM Gasto c ORDER BY c.descricao ", Gasto.class).getResultList();
		
	}

}