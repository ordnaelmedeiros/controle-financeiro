package com.medeiros.ordnael.controlefinanceiro.repository.gasto.subgrupo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medeiros.ordnael.controlefinanceiro.core.resource.Resource;
import com.medeiros.ordnael.controlefinanceiro.repository.gasto.grupo.GastoGrupo;
import com.medeiros.ordnael.controlefinanceiro.repository.gasto.grupo.GastoGrupoResource;

@Repository
public class GastoSubGrupoResource extends Resource<GastoSubGrupo> {

	@Autowired
	private GastoGrupoResource gastoGrupoResource;
	
	public GastoSubGrupoResource() {
		super(GastoSubGrupo.class);
	}

	@Override
	protected Map<String, Object> getFiltrosFixos() {
		Map<String, Object> filtros = new HashMap<>();
		filtros.put("gastoGrupo.id", this.getSuperId1());
		return filtros;
	}
	
	@Override
	protected void atualizaSuperIds(GastoSubGrupo entity) throws Exception {
		
		super.atualizaSuperIds(entity);
		GastoGrupo gastoGrupo = gastoGrupoResource.find(this.getSuperId1());
		entity.setGastoGrupo(gastoGrupo);
		
	}

}