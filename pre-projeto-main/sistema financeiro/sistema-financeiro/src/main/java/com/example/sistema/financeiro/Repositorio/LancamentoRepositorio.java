package com.example.sistema.financeiro.Repositorio;

import com.example.sistema.financeiro.modelo.Lancamento;
import com.example.sistema.financeiro.modelo.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepositorio extends JpaRepository<Lancamento, Long> {

    // Método combinado completo
    List<Lancamento> findByDescricaoContainingAndDataVencimentoGreaterThanEqualAndTipo(
            String descricao, LocalDate dataVencimento, TipoLancamento tipo);

    // Método combinado parcial (descrição + data)
    List<Lancamento> findByDescricaoContainingAndDataVencimentoGreaterThanEqual(
            String descricao, LocalDate dataVencimento);

    // Consulta por descrição
    List<Lancamento> findByDescricaoContaining(String descricao);

    // Consulta por data (JPQL)
    @Query("SELECT l FROM Lancamento l WHERE l.dataVencimento >= :data")
    List<Lancamento> findByDataVencimentoGreaterThanEqual(@Param("data") LocalDate data);

    // Consulta por tipo
    List<Lancamento> findByTipo(TipoLancamento tipo);

    // Consulta por pessoa
    List<Lancamento> findByPessoaId(Long pessoaId);

    // Consulta por descrição (case insensitive)
    List<Lancamento> findByDescricaoIgnoreCaseContaining(String descricao);
}