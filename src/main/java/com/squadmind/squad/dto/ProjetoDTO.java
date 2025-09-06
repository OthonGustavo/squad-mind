package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

    private int id;
    private String nome;
    private String codigoAcesso;
    private UsuarioDTO coordenador;

    public ProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.codigoAcesso = projeto.getCodigoAcesso();
        if (projeto.getCoordenador() != null) {
            this.coordenador = new UsuarioDTO(projeto.getCoordenador());
        }
    }
}