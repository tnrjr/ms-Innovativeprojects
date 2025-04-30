package com.acompanhamento.avaliacao.dtos;

import java.time.LocalDateTime;

public record IdeiaDTO(
        Long id,
        String titulo,
        String descricao,
        String autor,
        String status,
        LocalDateTime dataCriacao
) {}
