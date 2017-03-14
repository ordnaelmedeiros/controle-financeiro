package com.medeiros.ordnael.controlefinanceiro.core.validacao.impl;

import java.lang.reflect.Field;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.core.validacao.Validacao;

import ValidacaoCampoObrigatorioString.CampoInfo;

public class ValidacaoCampoObrigatorio<Model> extends Validacao<Model> {

	public ValidacaoCampoObrigatorio() {
		super("Campo Obrigatório: ");
	}

	@Override
	public void validar(Resource<Model> res, Model model) throws Exception {

		if (model!=null) {
			Field[] declaredFields = model.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(CampoInfo.class)) {
					CampoInfo info = field.getAnnotation(CampoInfo.class);
					if (info.obrigatorio()) {
						field.setAccessible(true);
						Object object = field.get(model);
						if (object==null) {
							throw new Exception(this.getMensagem() + info.descricao());
						}
					}
				}
			}
		}
		
	}

}
