package com.ferreira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreira.cursomc.domain.Categoria;
import com.ferreira.cursomc.repositories.CategoriaRepository;
import com.ferreira.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired // dependencia automaticamente instanciada pelo spring
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id+ ", Tipo: "+Categoria.class.getName()));
		} 
	
	public Categoria inserir(Categoria obj) {
		obj.setId(null); // Operação para garantir que realmente estamos inserindo um objeto novo, caso contrário é um update
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
