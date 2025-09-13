package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.AlternativaDTO;
import com.squadmind.squad.entity.Alternativa;

public class AlternativaMapper {
    public static AlternativaDTO toDTO(Alternativa alternativa){
        if (alternativa == null) return null;
        return new AlternativaDTO(alternativa);
    }
    public static Alternativa toEntity(AlternativaDTO dto){
        if (dto == null) return null;
        Alternativa alternativa = new Alternativa();
        alternativa.setId(dto.getId());
        alternativa.setTexto(dto.getTexto());
        alternativa.setValor(dto.getValor());
        return alternativa;
    }
}
