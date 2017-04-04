package com.medeiros.ordnael.casa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Table
@Entity
public class GastoSubGrupo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=5)
	private String sigla;
	
	@Column(length=200)
	private String descricao;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gastoGrupoId", foreignKey=@ForeignKey(name="fk_GastoSubGrupo_GastoGrupo"))
	private GastoGrupo gastoGrupo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GastoGrupo getGastoGrupo() {
		return gastoGrupo;
	}

	public void setGastoGrupo(GastoGrupo gastoGrupo) {
		this.gastoGrupo = gastoGrupo;
	}

}
