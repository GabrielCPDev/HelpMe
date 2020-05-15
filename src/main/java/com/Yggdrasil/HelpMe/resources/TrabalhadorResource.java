package com.Yggdrasil.HelpMe.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Yggdrasil.HelpMe.dto.TrabalhadorDTO;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.services.TrabalhadorService;

@RestController
@RequestMapping(value = "/trabalhadores")
public class TrabalhadorResource {

	@Autowired
	private TrabalhadorService service;
	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Trabalhador> find(@PathVariable Integer id) throws Exception {
		Trabalhador obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
   }	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Trabalhador obj) {
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Trabalhador obj, @PathVariable Integer id) throws Exception{
		obj.setId(id);
		obj= service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TrabalhadorDTO>> findAll(){
		List<Trabalhador> lista = service.listarTrabalhadores();
		List<TrabalhadorDTO> listaDto = lista.stream().map(obj ->new TrabalhadorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<TrabalhadorDTO>> findPage (
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "linhasPorPagina", defaultValue = "24")Integer linhasPorPagina, 
			@RequestParam(value = "ordenarPor", defaultValue = "nome")String ordenarPor,
			@RequestParam(value = "direcao", defaultValue = "ASC")String direcao){
		
		Page<Trabalhador> list = service.EncontrarPagina(pagina, linhasPorPagina, ordenarPor, direcao);
		Page<TrabalhadorDTO> listDto = list.map(obj -> new TrabalhadorDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
}
