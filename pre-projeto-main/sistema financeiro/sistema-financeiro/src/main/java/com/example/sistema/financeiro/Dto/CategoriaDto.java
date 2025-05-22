package com.example.sistema.financeiro.Dto;

import lombok.Data;

@Data
public class CategoriaDto {
    private Long id;
    private String nome;
    private Boolean ativo;
}