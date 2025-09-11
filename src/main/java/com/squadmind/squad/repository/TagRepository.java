package com.squadmind.squad.repository;

import com.squadmind.squad.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByQuestionario_Id(Long questionarioId);
}
