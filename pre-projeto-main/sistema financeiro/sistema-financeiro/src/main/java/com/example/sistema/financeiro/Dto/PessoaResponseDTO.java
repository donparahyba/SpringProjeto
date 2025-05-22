package com.example.sistema.financeiro.Dto;

import lombok.Data;

@Data
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private Boolean ativo;
    private PessoaDto endereco;
}
