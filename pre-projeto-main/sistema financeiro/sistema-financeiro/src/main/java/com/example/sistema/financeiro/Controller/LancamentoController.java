package com.example.sistema.financeiro.Controller;

import com.example.sistema.financeiro.modelo.Lancamento;
import com.example.sistema.financeiro.TipoDeServico.LancamentoService;
import com.example.sistema.financeiro.modelo.TipoLancamento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
    private final LancamentoService service;

    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lancamento> pesquisar(
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataVencimentoDe,
            @RequestParam(required = false) TipoLancamento tipo) {

        return service.pesquisar(descricao, dataVencimentoDe, tipo);
    }

    @GetMapping("/{pessoaId}/saldo")
    public BigDecimal calcularSaldo(@PathVariable Long pessoaId) {
        return service.calcularSaldoPorPessoa(pessoaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento criar(@RequestBody Lancamento lancamento) {
        return service.salvar(lancamento);
    }
}