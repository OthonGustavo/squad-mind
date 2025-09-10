package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Grupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDTO {

    private Long id;
    private String nomeGrupo;
    private Integer numeroGrupo;
    private String criterioFormacao;
    private Instant criadoEm;

    public GrupoDTO(Grupo grupo) {
        this.id = grupo.getId();
        this.nomeGrupo = grupo.getNome_grupo();
        this.numeroGrupo = grupo.getNumero_grupo();
        this.criterioFormacao = grupo.getCriterio_formacao();
        this.criadoEm = grupo.getCriado_em();
    }
}