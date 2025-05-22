package com.example.sistema.financeiro.modelo;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @Size(max = 9)
    private String cep;

    private String cidade;
    private String estado;
}