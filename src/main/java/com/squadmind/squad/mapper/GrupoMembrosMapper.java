package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.entity.GrupoMembros;

public class GrupoMembrosMapper {

    public static GrupoMembrosDTO toDTO(GrupoMembros membro) {
        if (membro == null) return null;
        return new GrupoMembrosDTO(membro);
    }
    public static GrupoMembros toEntity(GrupoMembrosDTO dto){
        if (dto == null) return null;
        GrupoMembros grupoMembros = new GrupoMembros();
        grupoMembros.setId(dto.getId());
        return grupoMembros;
    }
}
