package com.Yggdrasil.HelpMe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yggdrasil.HelpMe.entities.Cidade;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Estado;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.repositories.CidadeRepository;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;
import com.Yggdrasil.HelpMe.repositories.EstadoRepository;
import com.Yggdrasil.HelpMe.repositories.ProfissaoRepository;

@SpringBootApplication
public class HelpMeApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repo; 
	
	@Autowired
	private ProfissaoRepository profissaoReposity;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpMeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Profissao p1 = new Profissao(null, "Pedreiro");
		Profissao p2 = new Profissao(null, "Padeiro");
		Profissao p3 = new Profissao(null, "Confeiteiro");
		Profissao p4 = new Profissao(null, "Eletricista");
		Profissao p5 = new Profissao(null, "Ajudante de Padeiro");
		Profissao p6 = new Profissao(null, "Ajudante de Pedreiro");
		Profissao p7 = new Profissao(null, "Ajudante de Eletricista");
		
		
		
		Cliente cli1 = new Cliente();
		cli1.setId(null);
		cli1.setNome("Gabriel");
		cli1.setCpf("12345678909");
		cli1.setEmail("gabriel@live.com");
		cli1.setTelefone(999999999);
		cli1.setNota(null);
		cli1.getProfissoes().addAll(Arrays.asList(p1,p2));
		
		Cliente cli2 = new Cliente();
		cli2.setId(null);
		cli2.setNome("Marcelo");
		cli2.setCpf("44444444444");
		cli2.setEmail("marcelo@live.com");
		cli2.setTelefone(54925865);
		cli2.setNota(null);
		cli2.getProfissoes().addAll(Arrays.asList(p4,p2));
		
		Cliente cli3 = new Cliente();
		cli3.setId(null);
		cli3.setNome("Andre");
		cli3.setCpf("6548214578");
		cli3.setEmail("andre@live.com");
		cli3.setTelefone(65482569);
		cli3.setNota(null);
		cli3.getProfissoes().addAll(Arrays.asList(p6,p5));
		
		Cliente cli4 = new Cliente();
		cli4.setId(null);
		cli4.setNome("Matheus");
		cli4.setCpf("12345678909");
		cli4.setEmail("matheus@live.com");
		cli4.setTelefone(999999999);
		cli4.setNota(null);
		cli4.getProfissoes().addAll(Arrays.asList(p7,p3));
		
		p1.getClientes().addAll(Arrays.asList(cli1));
		p2.getClientes().addAll(Arrays.asList(cli2));
		p3.getClientes().addAll(Arrays.asList(cli4));
		p4.getClientes().addAll(Arrays.asList(cli2));
		p5.getClientes().addAll(Arrays.asList(cli3));
		p6.getClientes().addAll(Arrays.asList(cli3));
		p7.getClientes().addAll(Arrays.asList(cli4));
		
			
	
		repo.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
		profissaoReposity.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Bahia");
		Estado est4 = new Estado(null, "Rio de Janeiro");
		
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Mogi-Guaçu", est2);
		Cidade c3 = new Cidade(null, "Natalândia", est1);
		Cidade c4 = new Cidade(null, "Mogi-Mirim", est2);
		Cidade c5 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2, c4, c5));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
	}

}
