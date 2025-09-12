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
    private ProjetoDTO projeto;

    public GrupoDTO(Grupo grupo) {
        if (grupo != null) {
            this.id = grupo.getId();
            this.nomeGrupo = grupo.getNomeGrupo();
            this.numeroGrupo = grupo.getNumeroGrupo();
            this.criterioFormacao = grupo.getCriterioFormacao();
            this.criadoEm = grupo.getCriadoEm();

            if (grupo.getProjeto() != null) {
                this.projeto = new ProjetoDTO(grupo.getProjeto());
            }
        }
    }
}
