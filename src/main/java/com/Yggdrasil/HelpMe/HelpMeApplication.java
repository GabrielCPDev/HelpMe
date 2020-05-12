package com.Yggdrasil.HelpMe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yggdrasil.HelpMe.entities.Cidade;
import com.Yggdrasil.HelpMe.entities.Cliente;
import com.Yggdrasil.HelpMe.entities.Endereco;
import com.Yggdrasil.HelpMe.entities.Estado;
import com.Yggdrasil.HelpMe.entities.Pagamento;
import com.Yggdrasil.HelpMe.entities.PagamentoComCartao;
import com.Yggdrasil.HelpMe.entities.PagamentoComDinheiro;
import com.Yggdrasil.HelpMe.entities.Pedido;
import com.Yggdrasil.HelpMe.entities.Profissao;
import com.Yggdrasil.HelpMe.entities.enums.EstadoPagamento;
import com.Yggdrasil.HelpMe.entities.enums.TipoCliente;
import com.Yggdrasil.HelpMe.repositories.CidadeRepository;
import com.Yggdrasil.HelpMe.repositories.ClienteRepository;
import com.Yggdrasil.HelpMe.repositories.EnderecoRepository;
import com.Yggdrasil.HelpMe.repositories.EstadoRepository;
import com.Yggdrasil.HelpMe.repositories.PagamentoRepository;
import com.Yggdrasil.HelpMe.repositories.PedidoRepository;
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
	
	@Autowired
	private EnderecoRepository enterecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		cli1.setCpf("12345678909");
		cli1.setEmail("gabriel@live.com");
		cli1.setTipo(TipoCliente.FORNECESERVICO);
		cli1.setNota(null);
		cli1.getProfissoes().addAll(Arrays.asList(p1,p2));
		cli1.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		Cliente cli2 = new Cliente();
		cli2.setId(null);
		cli2.setNome("Marcelo");
		cli2.setCpf("44444444444");
		cli2.setEmail("marcelo@live.com");
		cli2.setNota(null);
		cli2.getProfissoes().addAll(Arrays.asList(p4,p2));
		cli2.setTipo(TipoCliente.FORNECESERVICO);
		cli2.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli2.getEnderecos().addAll(Arrays.asList(e2));


		
		
		Cliente cli3 = new Cliente();
		cli3.setId(null);
		cli3.setNome("Andre");
		cli3.setCpf("6548214578");
		cli3.setEmail("andre@live.com");
		cli3.setNota(null);
		cli3.getProfissoes().addAll(Arrays.asList(p6,p5));
		cli3.setTipo(TipoCliente.FORNECESERVICO);
		cli3.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli3.getEnderecos().addAll(Arrays.asList(e3));


		
		Cliente cli4 = new Cliente();
		cli4.setId(null);
		cli4.setNome("Matheus");
		cli4.setCpf("12345678909");
		cli4.setEmail("matheus@live.com");
		cli4.setNota(null);
		cli4.getProfissoes().addAll(Arrays.asList(p7,p3));
		cli4.setTipo(TipoCliente.FORNECESERVICO);
		cli4.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli4.getEnderecos().addAll(Arrays.asList(e4));


		
		Cliente cli5 = new Cliente();
		cli5.setId(null);
		cli5.setNome("Matheus");
		cli5.setCpf("12345678909");
		cli5.setEmail("matheus@live.com");
		cli5.setNota(null);
		cli5.getProfissoes().addAll(Arrays.asList(p7,p3));
		cli5.setTipo(TipoCliente.NAOFORNECESERVICO);
		cli5.getTelefones().addAll(Arrays.asList("38999999999","54888888888","11777777777"));
		cli5.getEnderecos().addAll(Arrays.asList(e5));

		
		p1.getClientes().addAll(Arrays.asList(cli1));
		p2.getClientes().addAll(Arrays.asList(cli2));
		p3.getClientes().addAll(Arrays.asList(cli4));
		p4.getClientes().addAll(Arrays.asList(cli2));
		p5.getClientes().addAll(Arrays.asList(cli3));
		p6.getClientes().addAll(Arrays.asList(cli3));
		p7.getClientes().addAll(Arrays.asList(cli4));
	
		e1.setCliente(cli1);
		e2.setCliente(cli2);
		e3.setCliente(cli3);
		e4.setCliente(cli4);
		e5.setCliente(cli5);		
			
		repo.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		
		profissaoReposity.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));	
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));		
		
		enterecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, cli1, p2, sdf.parse("30/09/2020 14:30"), (double) 300, e1);
		Pedido ped2 = new Pedido(null, cli2, p1, sdf.parse("20/07/2020 21:30"), (double) 700, e2);
		Pedido ped3 = new Pedido(null, cli3, p3, sdf.parse("10/10/2020 17:00"), (double) 1000, e3);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, cli1, e1, 6);
		ped1.setPamamento(pagto1);
		Pagamento pagto2 = new PagamentoComDinheiro(null, EstadoPagamento.PENDENTE, ped2, cli2, e2);
		ped2.setPamamento(pagto2);
		Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped3, cli3, e3, 12);
		ped3.setPamamento(pagto3);
		
		cli1.setPedidos(Arrays.asList(ped1));
		cli2.setPedidos(Arrays.asList(ped2));
		cli3.setPedidos(Arrays.asList(ped3));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3));
	}

}
