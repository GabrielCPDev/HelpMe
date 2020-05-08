package com.Yggdrasil.HelpMe.converters.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.Yggdrasil.HelpMe.PersonDTO;
import com.Yggdrasil.HelpMe.converters.Converter;
import com.Yggdrasil.HelpMe.entities.Cliente;

public class PessoaConverter implements Converter<Cliente, PersonDTO>{

	@Override
	public Cliente toEntity(PersonDTO dto) {
		Cliente p = new Cliente();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public PersonDTO toDto(Cliente entidade) {
		PersonDTO dto = new PersonDTO();
		try {
			BeanUtils.copyProperties(entidade, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dto;


	}

}
