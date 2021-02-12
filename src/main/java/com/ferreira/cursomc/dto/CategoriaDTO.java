package com.ferreira.cursomc.dto;

import com.ferreira.cursomc.domain.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

/**
 * com.ferreira.cursomc.dto
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 10/02/2021 - 16:11
 * @project cursomc
 */
@Data
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message="Preenchimento obrigatório")
    @Size(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
    }
}
