package com.example.sistema.financeiro.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "lancamentos")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String descricao;

    @NotNull
    @FutureOrPresent
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull
    @Positive
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @Size(max = 500)
    private String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}