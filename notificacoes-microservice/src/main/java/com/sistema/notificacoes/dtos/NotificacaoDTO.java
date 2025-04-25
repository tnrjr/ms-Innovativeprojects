package com.sistema.notificacoes.dtos;

import java.time.LocalDateTime;

public record NotificacaoDTO(
        Long id,
        String titulo,
        String mensagem,
        String destinatario,
        String tipo,
        LocalDateTime dataEnvio,
        Boolean enviada
) {}

