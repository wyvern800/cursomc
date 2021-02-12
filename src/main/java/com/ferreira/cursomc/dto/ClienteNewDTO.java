package com.ferreira.cursomc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * com.ferreira.cursomc.dto
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 12/02/2021 - 10:46
 * @project cursomc
 */
@Data
@NoArgsConstructor
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;
}
