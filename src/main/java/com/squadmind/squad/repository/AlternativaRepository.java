package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlternativaRepository extends JpaRepository<Alternativa,Long> {
    List<Alternativa> findByPergunta_id_Id(Long perguntaId);
}
