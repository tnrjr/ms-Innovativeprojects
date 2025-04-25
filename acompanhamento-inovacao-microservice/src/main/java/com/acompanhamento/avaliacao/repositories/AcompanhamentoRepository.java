package com.acompanhamento.avaliacao.repositories;

import com.acompanhamento.avaliacao.entities.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
    List<Acompanhamento> findByIdeiaId(Long ideiaId);
}
