package com.sistema.notificacoes.controllers;

import com.sistema.notificacoes.dtos.NotificacaoDTO;
import com.sistema.notificacoes.services.NotificacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {
    private final NotificacaoService service;

    @GetMapping
    public List<NotificacaoDTO> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> buscar(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/destinatario/{destinatario}")
    public List<NotificacaoDTO> listarPorDestinatario(@PathVariable String destinatario) {
        return service.listarPorDestinatario(destinatario);
    }

    @PostMapping
    public ResponseEntity<NotificacaoDTO> criar(@RequestBody @Valid NotificacaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

