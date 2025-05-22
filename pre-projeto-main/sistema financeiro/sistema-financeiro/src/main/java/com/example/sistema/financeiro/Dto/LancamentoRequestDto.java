package com.example.sistema.financeiro.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LancamentoRequestDto {
    @NotBlank
    @Size(max = 200)
    private String descricao;

    @NotNull
    @FutureOrPresent
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull
    @Positive
    private BigDecimal valor;

    @Size(max = 500)
    private String observacao;

    @NotNull
    private com.example.sistema.financeiro.modelo.TipoLancamento tipo;

    @NotNull
    private Long pessoaId;

    @NotNull
    private Long categoriaId;
}
