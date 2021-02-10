package com.ferreira.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.ferreira.cursomc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

		public List<Categoria> findAll() {
			return repo.findAll();
		}
	
	public Categoria inserir(Categoria obj) {
		obj.setId(null); // Operação para garantir que realmente estamos inserindo um objeto novo, caso contrário é um update
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	/**
	 * Cria uma página de categria
	 * @param page Id da página
	 * @param linesPerPage Linhas por pagina
	 * @param orderBy Campo que a pagina devera ser ordenado por ele
	 * @param direction Direção | {@code ASC} Ascendente, {@code DESC} Descendente
	 */
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
