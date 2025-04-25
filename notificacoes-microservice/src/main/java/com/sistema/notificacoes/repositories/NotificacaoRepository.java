package com.sistema.notificacoes.repositories;

import com.sistema.notificacoes.entities.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByDestinatario(String destinatario);
}

