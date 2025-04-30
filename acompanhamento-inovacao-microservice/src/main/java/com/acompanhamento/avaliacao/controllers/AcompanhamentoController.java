    package com.acompanhamento.avaliacao.controllers;
    
    import com.acompanhamento.avaliacao.dtos.AcompanhamentoComIdeiaDTO;
    import com.acompanhamento.avaliacao.dtos.AcompanhamentoDTO;
    import com.acompanhamento.avaliacao.services.AcompanhamentoService;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/acompanhamentos")
    @RequiredArgsConstructor
    public class AcompanhamentoController {
        private final AcompanhamentoService service;
    
        @GetMapping
        public List<AcompanhamentoDTO> listar() {
            return service.listarTodos();
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<AcompanhamentoComIdeiaDTO> buscar(@PathVariable Long id) {
            return service.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    
    
        @GetMapping("/ideia/{ideiaId}")
        public List<AcompanhamentoDTO> listarPorIdeia(@PathVariable Long ideiaId) {
            return service.listarPorIdeia(ideiaId);
        }
    
        @PostMapping
        public ResponseEntity<AcompanhamentoDTO> criar(@RequestBody @Valid AcompanhamentoDTO dto) {
            AcompanhamentoDTO salvo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(@PathVariable Long id) {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
    }
    
