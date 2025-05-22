package com.example.sistema.financeiro.Dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LancamentoDto {
    private Long id;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String observacao;
    private com.example.sistema.financeiro.modelo.TipoLancamento tipo;
    private String pessoaNome;
    private String categoriaNome;
}