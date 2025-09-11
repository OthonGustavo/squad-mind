package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<Pergunta,Long> {
    List<Pergunta> findByTag_Id(Long tagId);
    List<Pergunta> findByQuestionario_Id(Long questionarioId);
}
