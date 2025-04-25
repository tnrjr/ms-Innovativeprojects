package com.informacoes.financeiras.services;

import com.informacoes.financeiras.dtos.LancamentoFinanceiroDTO;
import com.informacoes.financeiras.entities.LancamentoFinanceiro;
import com.informacoes.financeiras.enums.StatusFinanceiro;
import com.informacoes.financeiras.enums.TipoDespesa;
import com.informacoes.financeiras.repositories.LancamentoFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinanceiroService {
    private final LancamentoFinanceiroRepository repository;

    public List<LancamentoFinanceiroDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public LancamentoFinanceiroDTO salvar(LancamentoFinanceiroDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public Optional<LancamentoFinanceiroDTO> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public List<LancamentoFinanceiroDTO> listarPorProjeto(Long projetoId) {
        return repository.findByProjetoId(projetoId).stream().map(this::toDTO).toList();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private LancamentoFinanceiroDTO toDTO(LancamentoFinanceiro entity) {
        return new LancamentoFinanceiroDTO(
                entity.getId(),
                entity.getProjetoId(),
                entity.getDescricao(),
                entity.getValor(),
                entity.getTipoDespesa().name(),
                entity.getStatus().name(),
                entity.getDataLancamento()
        );
    }

    private LancamentoFinanceiro toEntity(LancamentoFinanceiroDTO dto) {
        return new LancamentoFinanceiro(
                dto.id(),
                dto.projetoId(),
                dto.descricao(),
                dto.valor(),
                TipoDespesa.valueOf(dto.tipoDespesa().toUpperCase()),
                StatusFinanceiro.valueOf(dto.status().toUpperCase()),
                dto.dataLancamento()
        );
    }
}

