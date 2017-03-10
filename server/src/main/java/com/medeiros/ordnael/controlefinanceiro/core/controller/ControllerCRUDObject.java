package com.medeiros.ordnael.controlefinanceiro.core.controller;

import java.util.List;

public abstract class ControllerCRUDObject<Model> extends ControllerCRUD<Model> {

	private Class<Model> classe;
	
	public ControllerCRUDObject(Class<Model> classe) {
		this.classe = classe;
	}
	
	@Override
	public List<Model> pesquisar() throws Exception {
		return getResource().findAll(this.classe);
	}

	@Override
	public Model pesquisar(Long id) throws Exception {
		return getResource().find(this.classe, id);
	}

	@Override
	public Model gravar(Model model) throws Exception {
		return getResource().persist2(model);
	}

	@Override
	public Model alterar(Model model) throws Exception {
		return getResource().merge2(model);
	}

	@Override
	public boolean excluir(Long id) throws Exception {
		getResource().setClasse(classe);
		getResource().remove(id);
		return true;
	}

}
