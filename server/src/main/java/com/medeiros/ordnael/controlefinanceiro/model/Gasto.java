package com.medeiros.ordnael.controlefinanceiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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

@Table
@Entity
public class Gasto {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private LocalDate data;
	
	@Column(precision=12, scale=2)
    private BigDecimal valor;
	
	@Column(length=100)
    private String descricao;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gastoGrupoId", foreignKey=@ForeignKey(name="fk_Gasto_GastoGrupo"), insertable=false, updatable=false)
	private GastoGrupo gastoGrupo;
	
	@Column
	private Long gastoGrupoId;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gastoSubGrupoId", foreignKey=@ForeignKey(name="fk_Gasto_GastoSubGrupo"), insertable=false, updatable=false)
	private GastoSubGrupo gastoSubGrupo;

	@Column
	private Long gastoSubGrupoId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		if (this.gastoGrupo!=null) {
			this.setGastoGrupoId(this.gastoGrupo.getId());
		} else {
			this.setGastoGrupoId(null);
		}
	}

	public GastoSubGrupo getGastoSubGrupo() {
		return gastoSubGrupo;
	}

	public void setGastoSubGrupo(GastoSubGrupo gastoSubGrupo) {
		this.gastoSubGrupo = gastoSubGrupo;
		if (this.gastoSubGrupo!=null) {
			this.setGastoSubGrupoId(this.gastoSubGrupo.getId());
		} else {
			this.setGastoSubGrupoId(null);
		}
	}

	public Long getGastoSubGrupoId() {
		return gastoSubGrupoId;
	}

	public void setGastoSubGrupoId(Long gastoSubGrupoId) {
		this.gastoSubGrupoId = gastoSubGrupoId;
	}

	public Long getGastoGrupoId() {
		return gastoGrupoId;
	}

	public void setGastoGrupoId(Long gastoGrupoId) {
		this.gastoGrupoId = gastoGrupoId;
	}
	
}