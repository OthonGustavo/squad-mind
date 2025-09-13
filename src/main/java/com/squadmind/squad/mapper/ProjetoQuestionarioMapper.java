package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.ProjetoQuestionarioDTO;
import com.squadmind.squad.entity.ProjetoQuestionario;

public class ProjetoQuestionarioMapper {
    public static ProjetoQuestionarioDTO toDTO(ProjetoQuestionario projetoQuestionario){
        if (projetoQuestionario == null) return null;
        return new ProjetoQuestionarioDTO(projetoQuestionario);
    }
    public static ProjetoQuestionario toEntity(ProjetoQuestionarioDTO dto){
        if (dto == null) return null;
        ProjetoQuestionario projetoQuestionario = new ProjetoQuestionario();
        projetoQuestionario.setId(dto.getId());
        return projetoQuestionario;
    }
}
