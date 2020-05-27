package com.Yggdrasil.HelpMe;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yggdrasil.HelpMe.entities.Cidade;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Endereco;
import com.Yggdrasil.HelpMe.entities.Estado;
import com.Yggdrasil.HelpMe.entities.ItemPedido;
import com.Yggdrasil.HelpMe.entities.Pedido;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.entities.Trabalhador;
import com.Yggdrasil.HelpMe.repositories.CidadeRepository;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;
import com.Yggdrasil.HelpMe.repositories.EnderecoRepository;
import com.Yggdrasil.HelpMe.repositories.EstadoRepository;
import com.Yggdrasil.HelpMe.repositories.ItemPedidoRepository;
import com.Yggdrasil.HelpMe.repositories.PedidoRepository;
import com.Yggdrasil.HelpMe.repositories.ProfissaoRepository;
import com.Yggdrasil.HelpMe.repositories.TrabalhadorRepository;

@SpringBootApplication
public class HelpMeApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository; 

	@Autowired
	private TrabalhadorRepository trabalhadorRepository; 
	
	@Autowired
	private ProfissaoRepository profissaoReposity;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enterecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		Profissao p7 = new Profissao(null, "Mecânico");
		Profissao p8 = new Profissao(null, "Motorista");
		Profissao p9 = new Profissao(null, "Pintor");
		Profissao p10 = new Profissao(null, "Dançarino");
		Profissao p11 = new Profissao(null, "Mentiro(Político)");
		Profissao p12 = new Profissao(null, "Jardineiro");
		Profissao p13 = new Profissao(null, "Cantor");
		Profissao p14 = new Profissao(null, "Design");
		Profissao p15 = new Profissao(null, "Programador");
		Profissao p16 = new Profissao(null, "Super Vilão");
		Profissao p17 = new Profissao(null, "Super Herói");
		Profissao p18 = new Profissao(null, "Guerreiro Sayajin");
		Profissao p19 = new Profissao(null, "Assacino de aluguel");
		Profissao p20 = new Profissao(null, "Treinador Pokemon");
		
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
		
		Endereco e1 = new Endereco();
		e1.setBairro("Centro");
		e1.setCep("54433666");
		e1.setId(null);
		e1.setLogradouro(null);
		e1.setQuadra("100");
		e1.setComplemento("Ao lado da lex corp");
		e1.setCidade(c1);
				
		Endereco e2 = new Endereco();
		e2.setBairro("Cana Brava");
		e2.setCep("54433666");
		e2.setId(null);
		e2.setLogradouro(null);
		e2.setQuadra("200");
		e2.setComplemento("Ao lado da Capsule corp");
		e2.setCidade(c2);
				
		Endereco e3 = new Endereco();
		e3.setBairro("Mangal");
		e3.setCep("54433666");
		e3.setId(null);
		e3.setLogradouro(null);
		e3.setQuadra("300");
		e3.setComplemento("Ao lado da corporação Kaiba");
		e3.setCidade(c3);
				
		Endereco e4 = new Endereco();
		e4.setBairro("Mamoneira");
		e4.setCep("54433666");
		e4.setId(null);
		e4.setLogradouro(null);
		e4.setQuadra("400");
		e4.setComplemento("Ao lado da Ubrella Academy");
		e4.setCidade(c4);
				
		Endereco e5 = new Endereco();
		e5.setBairro("Centro");
		e5.setCep("54433666");
		e5.setId(null);
		e5.setLogradouro(null);
		e5.setQuadra("500");
		e5.setComplemento("Ao lado da Escola Xavier");
		e5.setCidade(c5);
			
		Cliente cli1 = new Cliente();
		cli1.setId(null);
		cli1.setNome("Gabriel");
		cli1.setCpfOuCnpj("12345678909");
		cli1.setEmail("gabriel@live.com");
		cli1.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		Trabalhador cli2 = new Trabalhador();
		cli2.setId(null);
		cli2.setNome("Marcelo");
		cli2.setCpfOuCnpj("44444444444");
		cli2.setEmail("marcelo@live.com");
		cli2.setNota(5.0);
		cli2.getProfissoes().addAll(Arrays.asList(p4,p2));
		cli2.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli2.getEnderecos().addAll(Arrays.asList(e2));


		
		
		Cliente cli3 = new Cliente();
		cli3.setId(null);
		cli3.setNome("Andre");
		cli3.setCpfOuCnpj("6548214578");
		cli3.setEmail("andre@live.com");
		cli3.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli3.getEnderecos().addAll(Arrays.asList(e3));


		
		Trabalhador cli4 = new Trabalhador();
		cli4.setId(null);
		cli4.setNome("Matheus");
		cli4.setCpfOuCnpj("12345678909");
		cli4.setEmail("matheus@live.com");
		cli4.setNota((double)3);
		cli4.getProfissoes().addAll(Arrays.asList(p7,p3));
		cli4.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli4.getEnderecos().addAll(Arrays.asList(e4));


		
		Cliente cli5 = new Cliente();
		cli5.setId(null);
		cli5.setNome("Matheus");
		cli5.setCpfOuCnpj("12345678909");
		cli5.setEmail("matheus@live.com");
		cli5.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli5.getEnderecos().addAll(Arrays.asList(e5));

		clienteRepository.saveAll(Arrays.asList(cli1, cli3, cli5));
		
		trabalhadorRepository.saveAll(Arrays.asList(cli2, cli4));
		
		p1.getTrabalhadores().addAll(Arrays.asList(cli2));
		p2.getTrabalhadores().addAll(Arrays.asList(cli2));
		p3.getTrabalhadores().addAll(Arrays.asList(cli4));
		p4.getTrabalhadores().addAll(Arrays.asList(cli2));
		p5.getTrabalhadores().addAll(Arrays.asList(cli4));
		p6.getTrabalhadores().addAll(Arrays.asList(cli2));
		p7.getTrabalhadores().addAll(Arrays.asList(cli4));
	
		e1.setPessoa(cli1);
		e2.setPessoa(cli2);
		e3.setPessoa(cli3);
		e4.setPessoa(cli4);
		e5.setPessoa(cli5);
		
		profissaoReposity.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20));	
		
		enterecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, cli1, sdf.parse("30/09/2020 14:30"), e1);
	
		Pedido ped2 = new Pedido(null, cli5, sdf.parse("30/09/2020 14:30"), e5);
		
		Pedido ped3 = new Pedido(null, cli3, sdf.parse("10/10/2020 14:30"),e3);
	
			
		cli1.setPedidos(Arrays.asList(ped1));
		cli5.setPedidos(Arrays.asList(ped2));
		cli3.setPedidos(Arrays.asList(ped3));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 2);
		ItemPedido ip2 = new ItemPedido(ped2, p2, 4);
		ItemPedido ip3 = new ItemPedido(ped3, p3, 3);

		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip2));
		ped3.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip3));
		
	
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
			
	}
}