package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.TipoDTO;
import com.squadmind.squad.entity.Tipo;

public class TipoMapper {

    public static TipoDTO toDTO(Tipo tipo) {
        if (tipo == null) return null;
        return new TipoDTO(tipo);
    }

}
