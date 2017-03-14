package com.medeiros.ordnael.controlefinanceiro.repository.usuario;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioEmailUnico;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioNomeAcessoUnico;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao.UsuarioSenhaObrigatorio;

@Repository
public class UsuarioResource extends Resource<Usuario> {

	public UsuarioResource() {
		super(Usuario.class);
		
		this.addValidPersistMerge(new UsuarioNomeAcessoUnico());
		this.addValidPersistMerge(new UsuarioEmailUnico());
		
		this.addValidPersist(new UsuarioSenhaObrigatorio());
		
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		return null;
	}

	@Override
	@Transactional
	public Usuario merge(Usuario model) throws Exception {
		
		if (model.getSenha()!=null) {
			Usuario usuarioOld = this.find(model.getId());
			model.setSenha(usuarioOld.getSenha());
		}
		
		return super.merge(model);
		
	}
	
}
