package com.example.sistema.financeiro.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequestDto {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
}
