package com.Yggdrasil.HelpMe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.Yggdrasil.HelpMe.entities.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trabalhador extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Double nota;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "trabalhadores")
	private List<Profissao> profissoes =  new ArrayList<>();
	
	
	public Trabalhador() {
	}


	public Trabalhador(Integer id, String nome, String cpfOuCnpj, String email, TipoPessoa tipo, Double nota) {
		super(id, nome, cpfOuCnpj, email, tipo);
		this.nota = nota;
	}


	public Double getNota() {
		return nota;
	}


	public void setNota(Double i) {
		this.nota = i;
	}


	public List<Profissao> getProfissoes() {
		return profissoes;
	}


	public void setProfissoes(List<Profissao> profissoes) {
		this.profissoes = profissoes;
	}
	
	
	
}
