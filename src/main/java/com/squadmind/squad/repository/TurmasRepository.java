package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmasRepository extends JpaRepository<Turmas,Long> {

    List<Turmas> findByProfessorId(Long professorId);

}
