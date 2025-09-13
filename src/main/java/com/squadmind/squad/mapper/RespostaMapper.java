package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.RespostaDTO;
import com.squadmind.squad.entity.Resposta;

public class RespostaMapper {

    public static RespostaDTO toDTO(Resposta resposta){
        if (resposta == null) return null;
        return new RespostaDTO(resposta);
    }

    public static Resposta toEntity(RespostaDTO respostaDTO){
        if (respostaDTO == null) return null;
        Resposta resposta = new Resposta();
        resposta.setId(respostaDTO.getId());
        resposta.setValor(respostaDTO.getValor());
        return resposta;
    }

}
