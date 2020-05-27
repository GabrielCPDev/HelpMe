package com.Yggdrasil.HelpMe.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.Yggdrasil.HelpMe.dto.PessoaNewDTO;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.entities.enums.TipoPessoa;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;
import com.Yggdrasil.HelpMe.repositories.TrabalhadorRepository;
import com.Yggdrasil.HelpMe.resources.exceptions.FieldMessage;
import com.Yggdrasil.HelpMe.services.validation.utils.BR;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaNewDTO> {
 
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	@Override
	public void initialize(PessoaInsert ann) {
	}
	
 	@Override
 	public boolean isValid(PessoaNewDTO objDto, ConstraintValidatorContext context) {
 		List<FieldMessage> list = new ArrayList<>();
 		
 		if(objDto.getTipo().equals(TipoPessoa.PESSOAFISICA.getCodigo()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
 			list.add(new FieldMessage("cpfOuCnpj","CPF inválido"));
 		}
 		
 		if(objDto.getTipo().equals(TipoPessoa.PESSOAJURIDICA.getCodigo()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
 			list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido"));
 		}

 		Cliente cliente = clienteRepository.findByEmail(objDto.getEmail());
 		
 		if(cliente != null) {
 			list.add(new FieldMessage("email", "Email já existe"));
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
