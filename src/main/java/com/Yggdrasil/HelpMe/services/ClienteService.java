package com.Yggdrasil.HelpMe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.dto.ClienteDTO;
import com.Yggdrasil.HelpMe.dto.ProfissaoDTO;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) throws Exception {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente não encontrado! " + id + " , Tipo: " + Cliente.class.getName()));
	}

	public Cliente salvar(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente atualizar (Cliente obj) throws Exception {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void excluir (Integer id) throws Exception {
		buscar(id);
		repo.deleteById(id);
	}
	public List<Cliente> listarClientes(){
		return repo.findAll();
	}
	
	public Page<Cliente> EncontrarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), null, null, null);
	}
	
}
