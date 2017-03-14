package com.medeiros.ordnael.controlefinanceiro.core.validacao;

public abstract class Validador<Model> {

	private String mensagem;
	//private Resource<Model> resource;
	
	public Validador( String mensagem) {
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

	public abstract void validar(Model model) throws Exception;
	
}
