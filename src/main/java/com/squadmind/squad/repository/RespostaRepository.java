package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta,Long> {

    List<Resposta> findByUsuario_id_Id(Long usuarioId);

    List<Resposta> findByProjeto_id_Id(Long projetoId);

    List<Resposta> findByPergunta_id_Id(Long perguntaId);

    List<Resposta> findByAlternativa_id_Id(Long alternativaId);

}
