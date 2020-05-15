package com.Yggdrasil.HelpMe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Profissao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "PROFISSAO_TRABALHADOR",
	joinColumns = @JoinColumn(name = "profissao_id"),
	inverseJoinColumns = @JoinColumn(name = "trabalhador_id")
)
	private List<Trabalhador> trabalhadores = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.profissao")
	private Set<ItemPedido> itens = new HashSet<>();
		
	public Profissao () {
	}

	public Profissao(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<Pedido>();
		for(ItemPedido x : itens) {
			lista.add(x.getPedido());			
		}
		
		return lista;
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

	public List<Trabalhador> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(List<Trabalhador> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

}
