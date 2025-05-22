package com.example.sistema.financeiro.Repositorio;

import com.example.sistema.financeiro.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome); // Deve corresponder ao campo

    List<Categoria> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT c FROM Categoria c WHERE c.ativo = true")
    List<Categoria> findCategoriasAtivas();
}