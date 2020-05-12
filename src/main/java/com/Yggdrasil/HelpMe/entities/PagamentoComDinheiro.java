package com.Yggdrasil.HelpMe.entities;

import javax.persistence.Entity;

import com.Yggdrasil.HelpMe.entities.enums.EstadoPagamento;

@Entity
public class PagamentoComDinheiro extends Pagamento{
	private static final long serialVersionUID = 1L;
	
		
	public PagamentoComDinheiro() {
	}

	public PagamentoComDinheiro(Integer id, EstadoPagamento estado, Pedido pedido, Cliente cliente,
			Endereco enderecoDoCliente) {
		super(id, estado, pedido, cliente, enderecoDoCliente);
		
	}
		
}
