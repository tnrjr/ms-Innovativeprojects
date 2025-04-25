package com.ideia.inovacao.entities;

import com.ideia.inovacao.enums.StatusIdeia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ideia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private String autor;

    @Enumerated(EnumType.STRING)
    private StatusIdeia status;

    private LocalDateTime dataCriacao;
}
