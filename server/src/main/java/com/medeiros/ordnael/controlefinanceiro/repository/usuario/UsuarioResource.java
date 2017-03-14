package com.medeiros.ordnael.controlefinanceiro.repository.usuario;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioEmailUnico;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioNomeAcessoUnico;

@Repository
public class UsuarioResource extends Resource<Usuario> {

	public UsuarioResource() {
		super(Usuario.class);
		
		this.addValidPersistMerge(new UsuarioNomeAcessoUnico());
		this.addValidPersistMerge(new UsuarioEmailUnico());
		
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		return null;
	}

}
