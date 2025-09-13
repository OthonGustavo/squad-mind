package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.ParticipanteDTO;
import com.squadmind.squad.entity.Participante;

public class ParticipanteMapper {
    public static ParticipanteDTO toDTO(Participante participante){
        if (participante == null) return null;
        return new ParticipanteDTO(participante);
    }
    public static Participante toEntity(ParticipanteDTO dto){
        if (dto == null) return null;
        Participante participante = new Participante();
        participante.setId(dto.getId());
        participante.setDataEntrada(dto.getDataEntrada());
        return participante;
    }
}
