package com.ideia.inovacao.controllers;

import com.ideia.inovacao.dtos.IdeiaDTO;
import com.ideia.inovacao.services.IdeiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/ideias")
@RequiredArgsConstructor
public class IdeiaController {
    private final IdeiaService ideiaService;

    @GetMapping
    public List<IdeiaDTO> listar() {
        return ideiaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<IdeiaDTO> criar(@RequestBody @Valid IdeiaDTO dto) {
        IdeiaDTO nova = ideiaService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdeiaDTO> buscar(@PathVariable Long id) {
        return ideiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        ideiaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
