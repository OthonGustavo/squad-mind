package com.squadmind.squad.repository;

import com.squadmind.squad.entity.PerfilResultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilResultadoRepository extends JpaRepository<PerfilResultado,Long> {

    // Buscar resultados de um usuário específico
    List<PerfilResultado> findByUsuario_Id(Long usuarioId);

    // Buscar resultados de um projeto específico
    List<PerfilResultado> findByProjeto_id_Id(Long projetoId);

    // Buscar resultados de um questionário específico
    List<PerfilResultado> findByQuestionario_id_Id(Long questionarioId);

    // Buscar resultados combinando usuário + projeto
    List<PerfilResultado> findByUsuario_IdAndProjeto_id_Id(Long usuarioId, Long projetoId);

    // Buscar resultados combinando usuário + questionário
    List<PerfilResultado> findByUsuario_IdAndQuestionario_id_Id(Long usuarioId, Long questionarioId);

}
