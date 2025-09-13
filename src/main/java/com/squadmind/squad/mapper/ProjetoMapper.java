package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.ProjetoDTO;
import com.squadmind.squad.entity.Projeto;

import java.util.stream.Collectors;

public class ProjetoMapper {

    public static ProjetoDTO toDTO(Projeto projeto) {
        if (projeto == null) return null;
        return new ProjetoDTO(projeto);
    }

    public static Projeto toEntity(ProjetoDTO dto){
        if (dto == null) return null;
        Projeto projeto = new Projeto();
        projeto.setId(dto.getId());
        projeto.setNome(dto.getNome());
        projeto.setQtd_grupos(dto.getQtdGrupos());
        return projeto;
    }

}
