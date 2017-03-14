package com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import com.medeiros.ordnael.controlefinanceiro.core.validacao.Validador;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.Usuario;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.UsuarioResource;

public class UsuarioNomeAcessoObrigatorio extends Validador<Usuario> {

	public UsuarioNomeAcessoObrigatorio() {
		super("Teste Erro");
	}

	@Autowired
	private UsuarioResource resource;
	
	@Override
	public void validar(Usuario model) throws Exception {
		throw new Exception(this.getMensagem());
	}

}
