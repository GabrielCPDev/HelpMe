package com.Yggdrasil.HelpMe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.dto.ProfissaoDTO;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.repositories.TrabalhadorRepository;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class TrabalhadorService {

	@Autowired
	private TrabalhadorRepository repo;

	public Trabalhador buscar(Integer id) throws Exception {
		Optional<Trabalhador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Trabalhador não encontrado! " + id + " , Tipo: " + Trabalhador.class.getName()));
	}

	public Trabalhador salvar(Trabalhador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Trabalhador atualizar (Trabalhador obj) throws Exception {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void excluir (Integer id) throws Exception {
		buscar(id);
		repo.deleteById(id);
	}
	
	public List<Trabalhador> listarTrabalhadores(){
		return repo.findAll();
	}
	
	public Page<Trabalhador> EncontrarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repo.findAll(pageRequest);
	}
	
	public Profissao fromDTO(ProfissaoDTO objDto) {
		return new Profissao(objDto.getId(), objDto.getNome());
	}
}
