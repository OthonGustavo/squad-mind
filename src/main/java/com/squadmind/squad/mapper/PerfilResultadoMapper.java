package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.entity.PerfilResultado;

public class PerfilResultadoMapper {
    public static PerfilResultadoDTO toDTO(PerfilResultado perfilResultado) {
        if (perfilResultado == null) return null;
        return new PerfilResultadoDTO(perfilResultado);
    }
    public static PerfilResultado toEntity(PerfilResultadoDTO dto){
        if (dto == null) return null;
        PerfilResultado perfilResultado = new PerfilResultado();
        perfilResultado.setId(dto.getId());
        perfilResultado.setPerfilDominante(dto.getPerfilDominante());
        perfilResultado.setPerfilTecnico(dto.getPerfilTecnico());
        return perfilResultado;
    }
}
