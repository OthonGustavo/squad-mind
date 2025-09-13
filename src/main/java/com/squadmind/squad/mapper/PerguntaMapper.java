package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.PerguntaDTO;
import com.squadmind.squad.entity.Pergunta;

public class PerguntaMapper {
    public static PerguntaDTO toDTO(Pergunta pergunta){
        if (pergunta == null) return null;
        return new PerguntaDTO(pergunta);
    }
    public static Pergunta toEntity(PerguntaDTO dto){
        if (dto == null) return null;
        Pergunta pergunta = new Pergunta();
        pergunta.setId(dto.getId());
        pergunta.setDescricao(dto.getDescricao());
        pergunta.setTipo(dto.getTipo());
        return pergunta;
    }
}
