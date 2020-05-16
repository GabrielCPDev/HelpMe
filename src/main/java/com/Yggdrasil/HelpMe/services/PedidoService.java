package com.Yggdrasil.HelpMe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Yggdrasil.HelpMe.dto.PedidoDTO;
import com.Yggdrasil.HelpMe.entities.Pedido;
import com.Yggdrasil.HelpMe.repositories.PedidoRepository;
import com.Yggdrasil.HelpMe.services.exceptions.DataIntegrityExceptionException;
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
	
	public Pedido atualizar(Pedido obj) throws Exception {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void excluir(Integer id) throws Exception {
		buscar(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptionException(e.getMessage());
		}
	}
	
	public List<Pedido> listarPedidos(){
		return repo.findAll();
	}
	
	public Page<Pedido> EncontrarPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao){
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repo.findAll(pageRequest);
	}
	
	public Pedido fromDTO(PedidoDTO objDto) {
		return new Pedido(objDto.getId(), objDto.getSolicitante(), objDto.getInstante(), objDto.getEnderecoDoSolicitante());
	}
	
}
