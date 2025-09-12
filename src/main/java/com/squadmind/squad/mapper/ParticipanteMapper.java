package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.ParticipanteDTO;
import com.squadmind.squad.entity.Participante;

public class ParticipanteMapper {
    public static ParticipanteDTO toDTO(Participante participante){
        if (participante == null) return null;
        return new ParticipanteDTO(participante);
    }
}
