package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.QuestionarioDTO;
import com.squadmind.squad.entity.Questionario;

public class QuestionarioMapper {

    public static QuestionarioDTO toDTO(Questionario questionario) {
        if (questionario == null) return null;
        return new QuestionarioDTO(questionario);
    }

    public static Questionario toEntity(QuestionarioDTO dto){
        if (dto == null) return null;
        Questionario questionario = new Questionario();
        questionario.setId(dto.getId());
        questionario.setNome(dto.getNome());
        questionario.setTipo(dto.getTipo());
        return questionario;
    }
}
