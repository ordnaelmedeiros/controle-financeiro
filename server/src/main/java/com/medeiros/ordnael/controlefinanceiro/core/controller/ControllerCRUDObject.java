package com.medeiros.ordnael.controlefinanceiro.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medeiros.ordnael.controlefinanceiro.core.resource.ResourceObject;

public class ControllerCRUDObject<Model> extends ControllerCRUD<Model> {

	Class<Model> classe;
	
	public ControllerCRUDObject(Class<Model> classe) {
		this.classe = classe;
	}
	
	@Autowired
	ResourceObject resource;
	
	@Override
	public List<Model> pesquisar() throws Exception {
		return resource.findAll(this.classe);
	}

	@Override
	public Model pesquisar(Long id) throws Exception {
		return resource.find(this.classe, id);
	}

	@Override
	public Model gravar(Model model) throws Exception {
		return resource.persist2(model);
	}

	@Override
	public Model alterar(Model model) throws Exception {
		return resource.merge2(model);
	}

	@Override
	public boolean excluir(Long id) throws Exception {
		resource.setClasse(classe);
		resource.remove(id);
		return true;
	}

}
