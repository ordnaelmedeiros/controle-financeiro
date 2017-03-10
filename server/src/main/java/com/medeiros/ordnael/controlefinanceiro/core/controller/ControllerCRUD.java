package com.medeiros.ordnael.controlefinanceiro.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

public abstract class ControllerCRUD<Model> {
	
	protected abstract List<Model> pesquisar() throws Exception;
	protected abstract Model pesquisar(Long id) throws Exception;
	protected abstract Model gravar(Model model) throws Exception;
	protected abstract Model alterar(Model model) throws Exception;
	protected abstract boolean excluir(Long id) throws Exception;

	protected abstract Resource<Model> getResource();
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Model> get() throws Exception {
		return this.pesquisar();
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public @ResponseBody Model get(
			@PathVariable Long id,
			@PathVariable(required=false) Long superId1
			) throws Exception {
		this.getResource().setSuperId1(superId1);
		return this.pesquisar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Model post(
			@RequestBody Model model,
			@PathVariable(required=false) Long superId1
			) throws Exception {
		this.getResource().setSuperId1(superId1);
		return this.gravar(model);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	protected @ResponseBody Model put(
			@RequestBody Model model,
			@PathVariable(required=false) Long superId1
			) throws Exception {
		this.getResource().setSuperId1(superId1);
		return this.alterar(model);
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	protected @ResponseBody boolean delete(
			@PathVariable Long id,
			@PathVariable(required=false) Long superId1
			) throws Exception {
		this.getResource().setSuperId1(superId1);
		return this.excluir(id);
	}
	
}