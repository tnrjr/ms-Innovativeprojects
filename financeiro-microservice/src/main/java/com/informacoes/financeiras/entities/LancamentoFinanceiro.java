package com.informacoes.financeiras.entities;

import com.informacoes.financeiras.enums.StatusFinanceiro;
import com.informacoes.financeiras.enums.TipoDespesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projetoId; // ou ideiaId, dependendo da origem

    private String descricao;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoDespesa tipoDespesa;

    @Enumerated(EnumType.STRING)
    private StatusFinanceiro status;

    private LocalDate dataLancamento;
}

