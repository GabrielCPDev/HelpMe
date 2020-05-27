package com.Yggdrasil.HelpMe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.Yggdrasil.HelpMe.entities.enums.TipoPessoa;

@Entity
public  class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;

	
	
	@OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL )
	private List<Pedido> pedidos =  new ArrayList<>();
	
	public Cliente() {
	}

	public Cliente(Integer id, String nome, String cpfOuCnpj, String email, TipoPessoa tipo) {
		super(id, nome, cpfOuCnpj, email, tipo);
		
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
