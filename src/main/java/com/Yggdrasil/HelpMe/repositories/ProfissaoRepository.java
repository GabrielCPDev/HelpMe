package com.Yggdrasil.HelpMe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yggdrasil.HelpMe.entities.Profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer>{

}
