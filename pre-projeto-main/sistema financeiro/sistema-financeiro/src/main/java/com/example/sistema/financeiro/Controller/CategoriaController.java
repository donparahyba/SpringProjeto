package com.example.sistema.financeiro.Controller;


import com.example.sistema.financeiro.modelo.Categoria;
import com.example.sistema.financeiro.TipoDeServico.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

    @GetMapping
    public List<Categoria> listar(@RequestParam(required = false) String nome) {
        if (nome != null) {
            return service.buscarPorNome(nome);
        }
        return service.listarTodasAtivas();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable Long id) {
        service.desativar(id);
    }
}