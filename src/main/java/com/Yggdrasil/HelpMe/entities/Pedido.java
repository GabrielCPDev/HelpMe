package com.Yggdrasil.HelpMe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente solicitante;	
	@OneToOne
	private Profissao profissao;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm ")
	private Date instante;	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	@OneToOne
	@JoinColumn(name = "enderecoDoSolicitante_id")
	private Endereco enderecoDoSolicitante;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
			
	public Pedido () {
	}

	public Pedido(Integer id,Cliente solicitante, Profissao profissao, Date instante, Endereco enderecoDoSolicitante) {
		super();
		this.id = id;
		this.profissao = profissao;
		this.instante = instante;
		this.enderecoDoSolicitante = enderecoDoSolicitante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getProfissao() {
		return profissao.getNome();
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPamamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
