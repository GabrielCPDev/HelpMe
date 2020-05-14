package com.Yggdrasil.HelpMe.dto;

import java.io.Serializable;

import com.Yggdrasil.HelpMe.entities.Profissao;

public class ProfissaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public ProfissaoDTO() {
	}
	
	public ProfissaoDTO(Profissao obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
