package com.Yggdrasil.HelpMe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yggdrasil.HelpMe.entities.Trabalhador;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Integer>{

}
