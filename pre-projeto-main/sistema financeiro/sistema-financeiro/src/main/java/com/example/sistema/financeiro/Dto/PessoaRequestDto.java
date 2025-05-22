package com.example.sistema.financeiro.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PessoaRequestDto {
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100)
    private String nome;

    @NotNull
    private Boolean ativo;

    private PessoaDto endereco;
}
