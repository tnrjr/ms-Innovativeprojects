package com.ideia.inovacao.services;

import com.ideia.inovacao.dtos.IdeiaDTO;
import com.ideia.inovacao.entities.Ideia;
import com.ideia.inovacao.enums.StatusIdeia;
import com.ideia.inovacao.repositories.IdeiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdeiaService {
    private final IdeiaRepository ideiaRepository;

    public List<IdeiaDTO> listarTodas() {
        return ideiaRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public IdeiaDTO salvar(IdeiaDTO dto) {
        return toDTO(ideiaRepository.save(toEntity(dto)));
    }

    public Optional<IdeiaDTO> buscarPorId(Long id) {
        return ideiaRepository.findById(id).map(this::toDTO);
    }

    public void excluir(Long id) {
        ideiaRepository.deleteById(id);
    }

    private IdeiaDTO toDTO(Ideia ideia) {
        return new IdeiaDTO(ideia.getId(), ideia.getTitulo(), ideia.getDescricao(),
                ideia.getAutor(), ideia.getStatus().name(), ideia.getDataCriacao());
    }

    private Ideia toEntity(IdeiaDTO dto) {
        return new Ideia(dto.id(), dto.titulo(), dto.descricao(), dto.autor(),
                StatusIdeia.valueOf(dto.status()), dto.dataCriacao());
    }

    public List<IdeiaDTO> listarPorStatus(String status) {
        return ideiaRepository.findByStatus(StatusIdeia.valueOf(status.toUpperCase()))
                .stream()
                .map(this::toDTO)
                .toList();
    }

}

