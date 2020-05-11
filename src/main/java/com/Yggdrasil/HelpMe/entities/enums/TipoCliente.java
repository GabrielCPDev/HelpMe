package com.Yggdrasil.HelpMe.entities.enums;

public enum TipoCliente {

	FORNECEDORDESERVICO(1, "Cliente que fornece serviços"),
	NAOFORNECEDORDESERVICO(2, "Cliente que não fornece serviços");
	
	private int codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()){
			
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + codigo);
	}
}
