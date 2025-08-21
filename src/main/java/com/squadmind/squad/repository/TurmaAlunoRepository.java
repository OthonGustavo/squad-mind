package com.squadmind.squad.repository;

import com.squadmind.squad.entity.TurmaAluno;
import com.squadmind.squad.entity.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno,Long> {
    
}
