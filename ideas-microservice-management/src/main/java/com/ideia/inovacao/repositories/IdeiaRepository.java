package com.ideia.inovacao.repositories;

import com.ideia.inovacao.entities.Ideia;
import com.ideia.inovacao.enums.StatusIdeia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeiaRepository extends JpaRepository<Ideia, Long> {
    List<Ideia> findByStatus(StatusIdeia status);

}

    