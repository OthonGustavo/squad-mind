package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Respostas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostasRepository extends JpaRepository<Respostas,Long> {

    List<Respostas> findByAlunoId_Id(Long alunoId);
    List<Respostas> findByTurmasId_Id(Long turmaId);

}
