package com.medeiros.ordnael.controlefinanceiro.repository.usuario.validacao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.core.validacao.Validacao;
import com.medeiros.ordnael.controlefinanceiro.repository.usuario.Usuario;

public class UsuarioNomeAcessoUnico extends Validacao<Usuario> {

	public UsuarioNomeAcessoUnico() {
		super("Nome de acesso do Usuário deve ser único");
	}

	@Override
	public void validar(Resource<Usuario> res, Usuario model) throws Exception {
		
		Criteria buscaMesmoNomeAcesso = res.createCriteria()
			.add(Restrictions.ilike("nomeacesso", model.getNomeacesso()));
		
		if (model.getId()!=null) {
			buscaMesmoNomeAcesso.add(Restrictions.ne("id", model.getId()));
		}
		
		List<?> list = buscaMesmoNomeAcesso.list();
		
		if (list!=null && list.size()>0) {
			throw new Exception(this.getMensagem());
		}
		
	}

}
