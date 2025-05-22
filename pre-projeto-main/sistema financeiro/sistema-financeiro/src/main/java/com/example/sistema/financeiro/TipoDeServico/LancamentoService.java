package com.example.sistema.financeiro.TipoDeServico;

import com.example.sistema.financeiro.modelo.*;
import com.example.sistema.financeiro.Repositorio.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class LancamentoService {
    private final LancamentoRepositorio repository;
    private final PessoaRepositorio pessoaRepository;
    private final CategoriaRepositorio categoriaRepository;

    public LancamentoService(LancamentoRepositorio repository,
                             PessoaRepositorio pessoaRepository,
                             CategoriaRepositorio categoriaRepository) {
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Lancamento salvar(Lancamento lancamento) {
        validarPessoa(lancamento.getPessoa());
        return repository.save(lancamento);
    }

    private void validarPessoa(Pessoa pessoa) {
        if (pessoa == null || pessoa.getId() == null) {
            throw new RuntimeException("Pessoa inválida");
        }

        pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public BigDecimal calcularSaldoPorPessoa(Long pessoaId) {
        List<Lancamento> lancamentos = repository.findByPessoaId(pessoaId);

        return lancamentos.stream()
                .map(l -> l.getTipo() == TipoLancamento.RECEITA ? l.getValor() : l.getValor().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Lancamento> pesquisar(String descricao, LocalDate dataVencimentoDe, TipoLancamento tipo) {
        // Se todos os parâmetros foram fornecidos
        if (descricao != null && dataVencimentoDe != null && tipo != null) {
            return repository.findByDescricaoContainingAndDataVencimentoGreaterThanEqualAndTipo(
                    descricao, dataVencimentoDe, tipo);
        }
        // Combinações de dois parâmetros
        else if (descricao != null && dataVencimentoDe != null) {
            return repository.findByDescricaoContainingAndDataVencimentoGreaterThanEqual(
                    descricao, dataVencimentoDe);
        }
        // Parâmetros individuais
        else if (descricao != null) {
            return repository.findByDescricaoContaining(descricao);
        } else if (dataVencimentoDe != null) {
            return repository.findByDataVencimentoGreaterThanEqual(dataVencimentoDe);
        } else if (tipo != null) {
            return repository.findByTipo(tipo);
        }
        // Sem parâmetros - retorna tudo
        return repository.findAll();
    }
}
