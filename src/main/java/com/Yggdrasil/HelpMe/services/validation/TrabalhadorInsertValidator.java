package com.Yggdrasil.HelpMe.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.Yggdrasil.HelpMe.dto.TrabalhadorNewDTO;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.entities.enums.TipoPessoa;
import com.Yggdrasil.HelpMe.repositories.TrabalhadorRepository;
import com.Yggdrasil.HelpMe.resources.exceptions.FieldMessage;
import com.Yggdrasil.HelpMe.services.validation.utils.BR;

public class TrabalhadorInsertValidator implements ConstraintValidator<TrabalhadorInsert, TrabalhadorNewDTO> {
 
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	@Override
	public void initialize(TrabalhadorInsert ann) {
	}
	
 	@Override
 	public boolean isValid(TrabalhadorNewDTO objDto, ConstraintValidatorContext context) {
 		List<FieldMessage> list = new ArrayList<>();
 		
 		if(objDto.getTipo().equals(TipoPessoa.PESSOAFISICA.getCodigo()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
 			list.add(new FieldMessage("cpfOuCnpj","CPF inválido"));
 		}
 		
 		if(objDto.getTipo().equals(TipoPessoa.PESSOAJURIDICA.getCodigo()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
 			list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido"));
 		}

 		Trabalhador trabalhador = trabalhadorRepository.findByEmail(objDto.getEmail());
 		
 		if(trabalhador != null) {
 			list.add(new FieldMessage("email", "Email já existe"));
 		}


 		for (FieldMessage e : list) {
 			context.disableDefaultConstraintViolation();
 			context.buildConstraintViolationWithTemplate(e.getMessage())
 			.addPropertyNode(e.getFieldName()).addConstraintViolation();
 		}

 		return list.isEmpty();
 	}
}
