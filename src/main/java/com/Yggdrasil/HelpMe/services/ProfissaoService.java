package com.Yggdrasil.HelpMe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.repositories.ProfissaoRepository;
import com.Yggdrasil.HelpMe.services.exceptions.DataIntegrityExceptionException;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao buscar (Integer id) throws Exception {
		Optional<Profissao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Profissão não encontrada! " + id + " , Tipo: " + Profissao.class.getName()));
	}
	
	public Profissao salvar(Profissao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void excluir(Integer id) throws Exception {
		buscar(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptionException("Não é possível excluir essa Profissão pois ela é solicitada em pedidos em aberto");
		}
	}
	
	public List<Profissao> listarProfissoes(){
		return repo.findAll();
	}
	
	public Page<Profissao> EncontrarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repo.findAll(pageRequest);
	}

}
