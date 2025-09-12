package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.QuestionarioDTO;
import com.squadmind.squad.entity.Questionario;

public class QuestionarioMapper {

    public static QuestionarioDTO toDTO(Questionario questionario) {
        if (questionario == null) return null;
        return new QuestionarioDTO(questionario);
    }
}
