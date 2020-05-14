package com.Yggdrasil.HelpMe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente solicitante;	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm ")
	private Date instante;		
	
	@OneToOne
	@JoinColumn(name = "enderecoDoSolicitante_id")
	private Endereco enderecoDoSolicitante;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
			
	public Pedido () {
	}

	public Pedido(Integer id,Cliente solicitante, Date instante, Endereco enderecoDoSolicitante) {
		super();
		this.id = id;
		this.instante = instante;
		this.solicitante = solicitante;
		this.enderecoDoSolicitante = enderecoDoSolicitante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}
	
	public Cliente getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	

	
	public Endereco getEnderecoDoSolicitante() {
		return enderecoDoSolicitante;
	}	
	
	public void setEnderecoDoSolicitante(Endereco enderecoDoSolicitante) {
		this.enderecoDoSolicitante = enderecoDoSolicitante;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
