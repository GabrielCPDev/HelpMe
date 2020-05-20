package com.Yggdrasil.HelpMe.entities;

import javax.persistence.Entity;

@Entity
public class PagamentoComDinheiro extends Pagamento{
	private static final long serialVersionUID = 1L;
	
		
	public PagamentoComDinheiro() {
	}

	public PagamentoComDinheiro(Integer id, Pedido pedido, Cliente cliente,
			Endereco enderecoDoCliente) {
		super(id, pedido, cliente, enderecoDoCliente);
		
	}
		
}
