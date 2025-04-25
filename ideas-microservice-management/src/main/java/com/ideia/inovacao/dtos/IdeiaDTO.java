package com.ideia.inovacao.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IdeiaDTO(
        Long id,
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotBlank String autor,
        @NotNull String status,
        @NotNull LocalDateTime dataCriacao
) {}


