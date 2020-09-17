package com.ferreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreira.cursomc.domain.Pedido;
import com.ferreira.cursomc.repositories.PedidoRepository;
import com.ferreira.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired // dependencia automaticamente instanciada pelo spring
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id+ ", Tipo: "+Pedido.class.getName()));
		} 
}
