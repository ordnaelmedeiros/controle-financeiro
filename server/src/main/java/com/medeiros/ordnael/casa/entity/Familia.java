package com.medeiros.ordnael.casa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.medeiros.ordnael.core.validacao.CampoInfo;

@Table
@Entity
public class Familia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@CampoInfo(descricao="Código")
	private Long id;
	
	@Column(length=200)
	@CampoInfo(descricao="Nome", obrigatorio=true)
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "familia_usuario",
		joinColumns = { @JoinColumn(name = "familiaid", foreignKey=@ForeignKey(name="fk_familia_usuario_familia")) },
		inverseJoinColumns = { @JoinColumn(name = "usuarioid", foreignKey=@ForeignKey(name="fk_familia_usuario_usuario")) }
	)
	private List<Usuario> usuarios;

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
