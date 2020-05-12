package com.Yggdrasil.HelpMe.entities;

import javax.persistence.Entity;

import com.Yggdrasil.HelpMe.entities.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
	}

	

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Cliente cliente,
			Endereco enderecoDoCliente, Integer numeroDeParcelas) {
		super(id, estado, pedido, cliente, enderecoDoCliente);
		this.numeroDeParcelas = numeroDeParcelas;
	}



	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
