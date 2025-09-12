package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

    private Long id;
    private String nome;
    private String codigoAcesso;
    private Integer qtdGrupos;
    private Boolean status;
    private Instant criadoEm;
    private UsuarioDTO coordenador;

    public ProjetoDTO(Projeto projeto) {
        if (projeto != null) {
            this.id = projeto.getId();
            this.nome = projeto.getNome();
            this.codigoAcesso = projeto.getCodigoAcesso();
            this.qtdGrupos = projeto.getQtd_grupos();
            this.status = projeto.getStatus();
            this.criadoEm = projeto.getCriado_em();

            if (projeto.getCoordenador() != null) {
                this.coordenador = new UsuarioDTO(projeto.getCoordenador());
            }
        }
    }
}
