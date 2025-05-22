package com.example.sistema.financeiro.modelo;


import jakarta.persistence.*;
import lombok.Data; // Import do Lombok

@Data // Gera automaticamente getters/setters
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Adicione estas anotações
    private String nome; // Campo deve ser "nome" (não "name")

    private Boolean ativo = true; // Adicione este campo se for usar desativação

    public Boolean isNone() {
        return this.nome == null || this.nome.isEmpty();
    }
}