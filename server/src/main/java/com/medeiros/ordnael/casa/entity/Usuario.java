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
import com.medeiros.ordnael.core.validacao.CampoInfo;

@Table
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@CampoInfo(descricao="Código")
	private Long id;
	
	@Column(length=200)
	@CampoInfo(descricao="Nome", obrigatorio=true)
	private String nome;
	
	@Column(length=200)
	@CampoInfo(descricao="Email", obrigatorio=true)
	private String email;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="acessoId", foreignKey=@ForeignKey(name="fk_usuario_acesso"))
	private Acesso acesso;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso login) {
		this.acesso = login;
	}
		
}
