package com.Yggdrasil.HelpMe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.dto.CategoriaDTO;
import com.Yggdrasil.HelpMe.entities.Categoria;
import com.Yggdrasil.HelpMe.repositories.CategoriaRepository;
import com.Yggdrasil.HelpMe.services.exceptions.DataIntegrityExceptionException;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar (Integer id) throws Exception {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Categoria não encontrada! " + id + " , Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria salvar(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria atualizar (Categoria obj) throws Exception {
		Categoria newObj = buscar(obj.getId());
		atualizarDados(newObj, obj);
		return repo.save(newObj);
	}
	
	public void excluir(Integer id) throws Exception {
		buscar(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptionException("Não é possível excluir essa Categoria pois existem profissões ligadas a ela!");
		}
	}
	
	public List<Categoria> listarCategoria(){
		return repo.findAll();
	}
	
	public Page<Categoria> EncontrarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	private void atualizarDados(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}
