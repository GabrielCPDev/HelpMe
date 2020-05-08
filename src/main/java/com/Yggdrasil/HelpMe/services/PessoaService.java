package com.Yggdrasil.HelpMe.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.repositories.PerssoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PerssoaRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Cliente salvar(Cliente cliente) {
		return repo.save(cliente);
	}
}
