package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GruposRepository extends JpaRepository<Grupos,Long> {

    List<Grupos> findByTurma_Id(Long turmaId);

}
