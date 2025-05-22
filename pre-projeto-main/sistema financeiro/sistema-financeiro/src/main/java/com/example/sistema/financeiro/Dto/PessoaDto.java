package com.example.sistema.financeiro.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PessoaDto {
    @Size(max = 100)
    private String logradouro;

    @Size(max = 20)
    private String numero;

    @Size(max = 100)
    private String complemento;

    @Size(max = 100)
    private String bairro;

    @Size(max = 9)
    private String cep;

    @Size(max = 100)
    private String cidade;

    @Size(max = 2)
    private String estado;
}