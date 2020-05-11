package com.Yggdrasil.HelpMe.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.repositories.ProfissaoRepository;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao buscar (Integer id) {
		Optional<Profissao> obj = repo.findById(id);
		return obj.orElse(null);
	}
	

}
