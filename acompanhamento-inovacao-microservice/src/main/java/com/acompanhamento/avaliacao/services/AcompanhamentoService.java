package com.acompanhamento.avaliacao.services;

import com.acompanhamento.avaliacao.dtos.AcompanhamentoComIdeiaDTO;
import com.acompanhamento.avaliacao.dtos.AcompanhamentoDTO;
import com.acompanhamento.avaliacao.dtos.IdeiaDTO;
import com.acompanhamento.avaliacao.entities.Acompanhamento;
import com.acompanhamento.avaliacao.enums.StatusEtapa;
import com.acompanhamento.avaliacao.feign.IdeiaClient;
import com.acompanhamento.avaliacao.repositories.AcompanhamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcompanhamentoService {
    private final AcompanhamentoRepository repository;
    private final IdeiaClient ideiaClient;

    public List<AcompanhamentoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public AcompanhamentoDTO salvar(AcompanhamentoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public Optional<AcompanhamentoComIdeiaDTO> buscarPorId(Long id) {
        return repository.findById(id).map(acom -> {
            IdeiaDTO ideia = ideiaClient.buscarIdeia(acom.getIdeiaId());
            return new AcompanhamentoComIdeiaDTO(
                    acom.getId(),
                    acom.getIdeiaId(),
                    acom.getObservacao(),
                    acom.getStatusEtapa().toString(),
                    acom.getDataRegistro(),
                    acom.getResponsavel(),
                    ideia
            );
        });
    }

    public List<AcompanhamentoDTO> listarPorIdeia(Long ideiaId) {
        return repository.findByIdeiaId(ideiaId).stream().map(this::toDTO).toList();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private AcompanhamentoDTO toDTO(Acompanhamento a) {
        return new AcompanhamentoDTO(
                a.getId(),
                a.getIdeiaId(),
                a.getObservacao(),
                a.getStatusEtapa().name(),
                a.getDataRegistro(),
                a.getResponsavel()
        );
    }

    private Acompanhamento toEntity(AcompanhamentoDTO dto) {
        return new Acompanhamento(
                dto.id(),
                dto.ideiaId(),
                dto.observacao(),
                StatusEtapa.valueOf(dto.statusEtapa().toUpperCase()),
                dto.dataRegistro(),
                dto.responsavel()
        );
    }
}
