package com.medeiros.ordnael.controlefinanceiro.repository.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.medeiros.ordnael.controlefinanceiro.core.validacao.CampoInfo;

@Table
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@CampoInfo(descricao="Código")
	private Long id;
	
	@Column(length=30)
	@CampoInfo(descricao="Nome de Acesso", obrigatorio=true)
	private String nomeacesso;
	
	@Column(length=200)
	@CampoInfo(descricao="Email", obrigatorio=true)
	private String email;
	
	@Column(length=64)
	@CampoInfo(descricao="Senha")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeacesso() {
		return nomeacesso;
	}

	public void setNomeacesso(String nomeacesso) {
		this.nomeacesso = nomeacesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
