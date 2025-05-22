package com.example.sistema.financeiro.TipoDeServico;


import com.example.sistema.financeiro.Repositorio.PessoaRepositorio;
import com.example.sistema.financeiro.modelo.Pessoa;
import com.example.sistema.financeiro.Repositorio.PessoaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepositorio repository;

    public PessoaService(PessoaRepositorio repository) {
        this.repository = repository;
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Transactional
    public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setAtivo(ativo);
        repository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}