package com.medeiros.ordnael.controlefinanceiro.core.validacao;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;

public abstract class Validacao<Model> {

	private String mensagem;
	//private Resource<Model> resource;
	
	public Validacao( String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	//public Resource<Model> getResource() {
	//	return resource;
	//}

	public abstract void validar(Resource<Model> res, Model model) throws Exception;
	
}
