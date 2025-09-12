package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.RespostaDTO;
import com.squadmind.squad.entity.Resposta;

public class RespostaMapper {

    public static RespostaDTO toDTO(Resposta resposta){
        if (resposta == null) return null;
        return new RespostaDTO(resposta);
    }

}
