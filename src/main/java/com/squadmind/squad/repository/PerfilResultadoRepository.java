package com.squadmind.squad.repository;

import com.squadmind.squad.entity.PerfilResultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilResultadoRepository extends JpaRepository<PerfilResultado, Long> {

    List<PerfilResultado> findByUsuario_Id(Long usuarioId);

    List<PerfilResultado> findByProjeto_Id(Long projetoId);

    List<PerfilResultado> findByQuestionario_Id(Long questionarioId);

    List<PerfilResultado> findByUsuario_IdAndProjeto_Id(Long usuarioId, Long projetoId);

    List<PerfilResultado> findByUsuario_IdAndQuestionario_Id(Long usuarioId, Long questionarioId);
}

