package com.squadmind.squad.repository;

import com.squadmind.squad.entity.TurmaAluno;
import com.squadmind.squad.entity.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno,Long> {

    List<TurmaAluno> findByTurmas_Id(Long turmaId);
    List<TurmaAluno> findByAluno_Id(Long alunoId);
    Optional<TurmaAluno> findByAluno_IdAndTurmas_Id(Long alunoId, Long turmaId);
    boolean existsByAluno_IdAndTurmas_Id(Long alunoId, Long turmaId);
    void deleteByAluno_IdAndTurmas_Id(Long alunoId, Long turmaId);
    
}
