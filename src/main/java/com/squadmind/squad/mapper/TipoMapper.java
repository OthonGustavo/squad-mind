package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.TipoDTO;
import com.squadmind.squad.entity.Tipo;

public class TipoMapper {

    public static TipoDTO toDTO(Tipo tipo) {
        if (tipo == null) return null;
        return new TipoDTO(tipo);
    }

    public static Tipo toEntity(TipoDTO tipoDTO){
        if (tipoDTO == null) return null;
        Tipo tipo = new Tipo();
        tipo.setId(tipoDTO.getId());
        tipo.setNome_tipo(tipo.getNome_tipo());
        return tipo;
    }

}
