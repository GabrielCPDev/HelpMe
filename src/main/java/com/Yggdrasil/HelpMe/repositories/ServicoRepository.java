package com.Yggdrasil.HelpMe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yggdrasil.HelpMe.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
