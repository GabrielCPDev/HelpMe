package com.Yggdrasil.HelpMe.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.Yggdrasil.HelpMe.dto.TrabalhadorDTO;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.repositories.TrabalhadorRepository;
import com.Yggdrasil.HelpMe.resources.exceptions.FieldMessage;

public class TrabalhadorUpdateValidator implements ConstraintValidator<TrabalhadorUpdate, TrabalhadorDTO> {
 
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(TrabalhadorUpdate ann) {
	}
	
 	@Override
 	public boolean isValid(TrabalhadorDTO objDto, ConstraintValidatorContext context) {
 		
 		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
 		Integer uriId = Integer.parseInt(map.get("id"));
		
 		List<FieldMessage> list = new ArrayList<>();
 		
 		Trabalhador trabalhador = trabalhadorRepository.findByEmail(objDto.getEmail());
 		
 		if(trabalhador != null && !trabalhador.getId().equals(uriId)) {
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
