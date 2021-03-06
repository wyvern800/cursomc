package com.ferreira.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.ferreira.cursomc.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ferreira.cursomc.domain.Categoria;
import com.ferreira.cursomc.services.CategoriaService;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/categorias") // end point
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	/**
	 * 
	 * @param id O ID da categoria à ser procurado no banco
	 * @return Resposta do tipo OK com corpo em JSON
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * 
	 * @param obj Objeto a ser inserido no banco
	 * @return Uma resposta
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id) {
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Deleta uma categoria através da variável ID
	 * @param id The id
	 * @return The response
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


	/**
	 * Retorna todas as categorias
	 * @return Lista das categorias
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();

		// Mapeia todos os objetos em um objeto DTO coletando apenas o ID/Nome, sem produtos
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value="page", defaultValue = "0") Integer page, @RequestParam(value="linesPerPage", defaultValue = "24")  Integer linesPerPage, @RequestParam(value="orderBy", defaultValue = "nome")  String orderBy, @RequestParam(value="direction", defaultValue = "ASC")  String direction) {
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);

		// Mapeia todos os objetos em um objeto DTO coletando apenas o ID/Nome, sem produtos
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
