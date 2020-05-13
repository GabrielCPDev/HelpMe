package com.Yggdrasil.HelpMe.converters;

public interface Converter<E,D> {
	
	public E toEntity(D dto);
	public D toDto(E entidade);
}
