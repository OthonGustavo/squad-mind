package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.PerguntaDTO;
import com.squadmind.squad.entity.Pergunta;

public class PerguntaMapper {
    public static PerguntaDTO toDTO(Pergunta pergunta){
        if (pergunta == null) return null;
        return new PerguntaDTO(pergunta);
    }
}
