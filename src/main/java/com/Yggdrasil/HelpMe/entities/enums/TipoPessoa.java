package com.Yggdrasil.HelpMe.entities.enums;

public enum TipoPessoa {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessao Jurídica");
	
	private int codigo;
	private String descricao;
	
	private TipoPessoa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPessoa toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for(TipoPessoa x : TipoPessoa.values()){
			
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + codigo);
	}
}
