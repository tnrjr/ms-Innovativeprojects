package com.informacoes.financeiras.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LancamentoFinanceiroDTO(
        Long id,
        Long projetoId,
        String descricao,
        BigDecimal valor,
        String tipoDespesa,
        String status,
        LocalDate dataLancamento
) {}

