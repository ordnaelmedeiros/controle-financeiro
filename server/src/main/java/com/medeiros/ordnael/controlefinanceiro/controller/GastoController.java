package com.medeiros.ordnael.controlefinanceiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;
import com.medeiros.ordnael.controlefinanceiro.repository.GastoRepository;

@Controller
@RequestMapping("/gasto")
public class GastoController {
 
	@Autowired
	GastoRepository repository;
 
 
	@RequestMapping(value ="/cadastrar.html", method= RequestMethod.GET)
	public ModelAndView Cadastrar(){
 
		return new ModelAndView("cadastrar");
		
	}	
 
 
	@RequestMapping(method= RequestMethod.POST)
	public @ResponseBody Gasto Salvar(@RequestBody Gasto gasto){
 
		try {
 
			repository.Salvar(gasto);
 
 
		} catch (Exception e) {
 
			//resultadoModel.setCodigo(2);
			//resultadoModel.setMensagem("Erro ao salvar o registro ("+e.getMessage()+")");
			
			e.printStackTrace();
			
		}
 
		return gasto;
	}
 
	/**
	 * Altera um registro cadastrado (editarRegistroController.js)
	 * 
	 *
	 */
	@RequestMapping(method= RequestMethod.PUT)
	public @ResponseBody Gasto Alterar(@RequestBody Gasto gasto){
 
		try {
			
			repository.Alterar(gasto);
 
		} catch (Exception e) {
			
			e.printStackTrace();
 
		}
 
		return gasto;
	}
 
 
	@RequestMapping(value="/consultarTodos", method= RequestMethod.GET)
	public @ResponseBody List<Gasto> ConsultarTodos(){
 
		return repository.TodosUsuarios();
 
	}
	
	@RequestMapping(value="/{codigo}", method= RequestMethod.GET)
	public @ResponseBody Gasto pesquisa(@PathVariable Long codigo){
 
		return repository.ConsultarPorCodigo(codigo);
 
	}
 
	@RequestMapping(value="/{codigo}", method= RequestMethod.DELETE)
	public @ResponseBody void ExcluirRegistro(@PathVariable Long codigo){
		
		repository.Excluir(codigo);
 
	}
 
}