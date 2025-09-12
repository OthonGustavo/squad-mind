package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.AlternativaDTO;
import com.squadmind.squad.entity.Alternativa;

public class AlternativaMapper {
    public static AlternativaDTO toDTO(Alternativa alternativa){
        if (alternativa == null) return null;
        return new AlternativaDTO(alternativa);
    }
}
