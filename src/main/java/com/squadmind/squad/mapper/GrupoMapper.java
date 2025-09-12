package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.GrupoDTO;
import com.squadmind.squad.entity.Grupo;

import java.util.stream.Collectors;

public class GrupoMapper {

    public static GrupoDTO toDTO(Grupo grupo) {
        if (grupo == null) return null;
        return new GrupoDTO(grupo);
    }
}
