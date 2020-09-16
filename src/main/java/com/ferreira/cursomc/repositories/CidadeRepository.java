package com.ferreira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ferreira.cursomc.domain.Cidade;
import com.ferreira.cursomc.domain.Produto;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
