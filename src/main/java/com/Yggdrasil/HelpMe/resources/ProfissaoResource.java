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

import com.Yggdrasil.HelpMe.dto.ProfissaoDTO;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.services.ProfissaoService;

@RestController
@RequestMapping(value = "/profissoes")
public class ProfissaoResource {

	@Autowired
	private ProfissaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profissao>find(@PathVariable Integer id) throws Exception{
		Profissao obj =  service.buscar(id);
		return ResponseEntity.ok().body(obj);
		}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Profissao obj) {
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
   }
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
		service.excluir(id);
		return ResponseEntity.noContent().build();
		}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfissaoDTO>> findAll(){
		List<Profissao> lista = service.listarProfissoes();
		List<ProfissaoDTO> listaDto = lista.stream().map(obj ->new ProfissaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProfissaoDTO>> findPage (
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "linhasPorPagina", defaultValue = "24")Integer linhasPorPagina, 
			@RequestParam(value = "ordenarPor", defaultValue = "nome")String ordenarPor,
			@RequestParam(value = "direcao", defaultValue = "ASC")String direcao){
		
		Page<Profissao> list = service.EncontrarPagina(pagina, linhasPorPagina, ordenarPor, direcao);
		Page<ProfissaoDTO> listDto = list.map(obj -> new ProfissaoDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
	
}
