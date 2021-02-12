package com.ferreira.cursomc.dto;

import com.ferreira.cursomc.domain.Categoria;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * com.ferreira.cursomc.dto
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 10/02/2021 - 16:11
 * @project cursomc
 */
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
