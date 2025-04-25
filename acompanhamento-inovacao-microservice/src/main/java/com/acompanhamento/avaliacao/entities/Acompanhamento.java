package com.acompanhamento.avaliacao.entities;

import com.acompanhamento.avaliacao.enums.StatusEtapa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Acompanhamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ideiaId; // ou projetoId, no futuro

    private String observacao;

    @Enumerated(EnumType.STRING)
    private StatusEtapa statusEtapa;

    private LocalDateTime dataRegistro;

    private String responsavel;
}

