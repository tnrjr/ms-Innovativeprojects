package com.sistema.notificacoes.entities;

import com.sistema.notificacoes.enums.TipoNotificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private String destinatario;

    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipo;

    private LocalDateTime dataEnvio;

    private Boolean enviada = false;
}

