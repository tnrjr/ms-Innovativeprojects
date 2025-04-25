package com.informacoes.financeiras.controllers;

import com.informacoes.financeiras.dtos.LancamentoFinanceiroDTO;
import com.informacoes.financeiras.services.FinanceiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiros")
@RequiredArgsConstructor
public class FinanceiroController {
    private final FinanceiroService service;

    @GetMapping
    public List<LancamentoFinanceiroDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoFinanceiroDTO> buscar(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/projeto/{projetoId}")
    public List<LancamentoFinanceiroDTO> listarPorProjeto(@PathVariable Long projetoId) {
        return service.listarPorProjeto(projetoId);
    }

    @PostMapping
    public ResponseEntity<LancamentoFinanceiroDTO> criar(@RequestBody @Valid LancamentoFinanceiroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
