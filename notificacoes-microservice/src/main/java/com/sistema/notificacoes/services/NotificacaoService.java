package com.sistema.notificacoes.services;

import com.sistema.notificacoes.dtos.NotificacaoDTO;
import com.sistema.notificacoes.entities.Notificacao;
import com.sistema.notificacoes.enums.TipoNotificacao;
import com.sistema.notificacoes.repositories.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificacaoService {
    private final NotificacaoRepository repository;

    public List<NotificacaoDTO> listarTodas() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public NotificacaoDTO salvar(NotificacaoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public Optional<NotificacaoDTO> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public List<NotificacaoDTO> listarPorDestinatario(String destinatario) {
        return repository.findByDestinatario(destinatario).stream().map(this::toDTO).toList();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private NotificacaoDTO toDTO(Notificacao n) {
        return new NotificacaoDTO(
                n.getId(),
                n.getTitulo(),
                n.getMensagem(),
                n.getDestinatario(),
                n.getTipo().name(),
                n.getDataEnvio(),
                n.getEnviada()
        );
    }

    private Notificacao toEntity(NotificacaoDTO dto) {
        return new Notificacao(
                dto.id(),
                dto.titulo(),
                dto.mensagem(),
                dto.destinatario(),
                TipoNotificacao.valueOf(dto.tipo().toUpperCase()),
                dto.dataEnvio(),
                dto.enviada() != null ? dto.enviada() : false
        );
    }
}

