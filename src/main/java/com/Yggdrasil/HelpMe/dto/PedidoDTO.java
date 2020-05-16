package com.Yggdrasil.HelpMe.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Endereco;
import com.Yggdrasil.HelpMe.entities.ItemPedido;
import com.Yggdrasil.HelpMe.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoDTO implements Serializable {
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
	
	public PedidoDTO() {
	}
	
	public PedidoDTO(Pedido obj) {
		super();
		this.id = obj.getId();
		this.solicitante = obj.getSolicitante();
		this.instante = obj.getInstante();
		this.enderecoDoSolicitante = obj.getEnderecoDoSolicitante();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Endereco getEnderecoDoSolicitante() {
		return enderecoDoSolicitante;
	}

	public void setEnderecoDoSolicitante(Endereco enderecoDoSolicitante) {
		this.enderecoDoSolicitante = enderecoDoSolicitante;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
}
