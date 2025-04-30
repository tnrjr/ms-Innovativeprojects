package com.acompanhamento.avaliacao.dtos;

import java.time.LocalDateTime;

public record AcompanhamentoComIdeiaDTO(
        Long id,
        Long ideiaId,
        String observacao,
        String statusEtapa,
        LocalDateTime dataRegistro,
        String responsavel,
        IdeiaDTO ideia
) {}
