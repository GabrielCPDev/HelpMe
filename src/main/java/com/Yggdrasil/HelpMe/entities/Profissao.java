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
	@ManyToMany
	@JoinTable(name = "PROFISSAO_CATEGORIA",
		joinColumns = @JoinColumn(name = "profissao_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
		
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
	public List<Categoria> getCategrias() {
		return categorias;
	}

	public void setCategrias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissao other = (Profissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
