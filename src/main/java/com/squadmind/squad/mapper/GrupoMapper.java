package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.GrupoDTO;
import com.squadmind.squad.entity.Grupo;

public class GrupoMapper {

    public static GrupoDTO toDTO(Grupo grupo) {
        if (grupo == null) return null;
        return new GrupoDTO(grupo);
    }
    public static Grupo toEntity(GrupoDTO dto){
        if (dto == null) return null;
        Grupo grupo = new Grupo();
        grupo.setId(dto.getId());
        grupo.setNomeGrupo(dto.getNomeGrupo());
        grupo.setNumeroGrupo(dto.getNumeroGrupo());
        grupo.setCriterioFormacao(dto.getCriterioFormacao());
        return grupo;
    }
}
