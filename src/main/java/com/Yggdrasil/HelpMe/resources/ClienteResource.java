package com.Yggdrasil.HelpMe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Yggdrasil.HelpMe.PersonDTO;
import com.Yggdrasil.HelpMe.converters.impl.PessoaConverter;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.services.ClienteService;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;




@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws Exception {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
   }
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody PersonDTO pessoaDTO) {
		PessoaConverter converter = new PessoaConverter();
		Cliente cliente = converter.toEntity(pessoaDTO);
		Cliente obj = service.salvar(cliente);
		return ResponseEntity.ok().body(obj);	
   }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody PersonDTO dtoDTO) {
		throw new ObjetoNaoEncontradoException("Objeto não encontrado!");
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(Integer id) {
		throw new ObjetoNaoEncontradoException("Objeto não encontrado!");
	}
}	
