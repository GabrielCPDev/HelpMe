package com.Yggdrasil.HelpMe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;

@SpringBootApplication
public class HelpMeApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repo; 
	
	public static void main(String[] args) {
		SpringApplication.run(HelpMeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cli1 = new Cliente();
		cli1.setId(null);
		cli1.setNome("Gabriel");
		cli1.setCpf("12345678909");
		cli1.setEmail("gabriel@live.com");
		cli1.setTelefone(999999999);
		cli1.setNota(null);
		cli1.setProfissoes(null);
		
		Cliente cli2 = new Cliente();
		cli2.setId(null);
		cli2.setNome("Marcelo");
		cli2.setCpf("44444444444");
		cli2.setEmail("marcelo@live.com");
		cli2.setTelefone(54925865);
		cli2.setNota(null);
		cli2.setProfissoes(null);
		
		Cliente cli3 = new Cliente();
		cli3.setId(null);
		cli3.setNome("Andre");
		cli3.setCpf("6548214578");
		cli3.setEmail("andre@live.com");
		cli3.setTelefone(65482569);
		cli3.setNota(null);
		cli3.setProfissoes(null);
		
		Cliente cli4 = new Cliente();
		cli4.setId(null);
		cli4.setNome("Matheus");
		cli4.setCpf("12345678909");
		cli4.setEmail("matheus@live.com");
		cli4.setTelefone(999999999);
		cli4.setNota(null);
		cli4.setProfissoes(null);
		
		repo.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
		
	}

}
