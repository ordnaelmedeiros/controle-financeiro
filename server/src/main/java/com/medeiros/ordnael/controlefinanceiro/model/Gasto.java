package com.medeiros.ordnael.controlefinanceiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Gasto {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gastoId;
	
	@Column
    private LocalDate data;
	
	@Column(precision=12, scale=2)
    private BigDecimal valor;
	
	@Column(length=100)
    private String descricao;

	public Long getGastoId() {
		return gastoId;
	}
	public void setGastoId(Long gastoId) {
		this.gastoId = gastoId;
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
	
}