package com.informacoes.financeiras.repositories;

import com.informacoes.financeiras.entities.LancamentoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentoFinanceiroRepository extends JpaRepository<LancamentoFinanceiro, Long> {
    List<LancamentoFinanceiro> findByProjetoId(Long projetoId);
}

