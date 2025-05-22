package com.example.sistema.financeiro.Repositorio;

import com.example.sistema.financeiro.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContaining(String nome);
}