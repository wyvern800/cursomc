package com.ferreira.cursomc.dto;

import com.ferreira.cursomc.domain.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * com.ferreira.cursomc.dto
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 12/02/2021 - 09:42
 * @project cursomc
 */
@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres!")
    private String nome;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}
