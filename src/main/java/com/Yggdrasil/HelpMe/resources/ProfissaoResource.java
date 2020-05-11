package com.Yggdrasil.HelpMe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.services.ProfissaoService;

@RestController
@RequestMapping(value = "/profissoes")
public class ProfissaoResource {

	@Autowired
	private ProfissaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Integer id) throws Exception{
		Profissao obj =  service.buscar(id);
		return ResponseEntity.ok().body(obj);
		}
}
