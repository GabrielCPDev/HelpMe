package com.Yggdrasil.HelpMe.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.entities.Pedido;
import com.Yggdrasil.HelpMe.repositories.PedidoRepository;
import com.Yggdrasil.HelpMe.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PedidoService {

	@Autowired
	public PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente não encontrado! " + id + " , Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido salvar(Pedido pedido) {
		return repo.save(pedido);
	}
}
