package com.example.sistema.financeiro.TipoDeServico;


import com.example.sistema.financeiro.modelo.Categoria;
import com.example.sistema.financeiro.Repositorio.CategoriaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepositorio repository;

    public CategoriaService(CategoriaRepositorio repository) {
        this.repository = repository;
    }

    @Transactional
    public Categoria salvar(Categoria categoria) {
        // Verificação adicional
        if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório");
        }

        repository.findByNome(categoria.getNome())
                .ifPresent(c -> {
                    throw new RuntimeException("Já existe uma categoria com este nome");
                });

        return repository.save(categoria);
    }

    public List<Categoria> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Categoria> listarTodasAtivas() {
        return repository.findCategoriasAtivas();
    }

    @Transactional
    public void desativar(Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setAtivo(false);
        repository.save(categoria);
    }
}