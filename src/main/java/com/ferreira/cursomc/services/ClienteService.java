package com.ferreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ferreira.cursomc.domain.Cliente;
import com.ferreira.cursomc.repositories.ClienteRepository;
import com.ferreira.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired // dependencia automaticamente instanciada pelo spring
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id+ ", Tipo: "+Cliente.class.getName()));
		} 
}
