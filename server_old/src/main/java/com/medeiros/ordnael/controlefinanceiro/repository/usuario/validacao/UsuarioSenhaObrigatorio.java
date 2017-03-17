package com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.core.validacao.Validacao;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.Usuario;

public class UsuarioSenhaObrigatorio extends Validacao<Usuario> {

	public UsuarioSenhaObrigatorio() {
		super("Campo Obrigatório: Senha");
	}

	@Override
	public void validar(Resource<Usuario> res, Usuario model) throws Exception {
		
		if (model!=null && model.getSenha()==null) {
			throw new Exception(this.getMensagem());
		}
		
	}

}
