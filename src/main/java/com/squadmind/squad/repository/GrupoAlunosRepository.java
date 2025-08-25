package com.squadmind.squad.repository;

import com.squadmind.squad.entity.GrupoAlunos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GrupoAlunosRepository extends JpaRepository<GrupoAlunos,Long> {

    List<GrupoAlunos> findByGrupo_Alunos_Id(Long grupoId);
    List<GrupoAlunos> findByAluno_Id(Long alunoId);
    Optional<GrupoAlunos> findByAluno_IdAndGrupo_Alunos_Id(Long alunoId, Long grupoId);
    boolean existsByAluno_IdAndGrupo_Alunos_Id(Long alunoId, Long grupoId);
    void deleteByAluno_IdAndGrupo_Alunos_Id(Long alunoId, Long grupoId);

}
