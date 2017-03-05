package com.medeiros.ordnael.controlefinanceiro.core.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class ControllerCRUD<Model> {
	
	protected abstract List<Model> pesquisar() throws Exception;
	protected abstract Model pesquisar(Long id) throws Exception;
	protected abstract Model gravar(Model model) throws Exception;
	protected abstract Model alterar(Model model) throws Exception;
	protected abstract boolean excluir(Long id) throws Exception;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Model> get() throws Exception {
		return this.pesquisar();
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public @ResponseBody Model get(@PathVariable Long id) throws Exception {
		return this.pesquisar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Model post(@RequestBody Model model) throws Exception {
		return this.gravar(model);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	protected @ResponseBody Model put(@RequestBody Model model) throws Exception {
		return this.alterar(model);
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	protected @ResponseBody boolean delete(@PathVariable Long id) throws Exception {
		return this.excluir(id);
	}
	
}