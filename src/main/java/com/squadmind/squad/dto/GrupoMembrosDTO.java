package com.squadmind.squad.dto;

import com.squadmind.squad.entity.GrupoMembros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrupoMembrosDTO {

    private Long id;
    private GrupoDTO grupo;
    private UsuarioDTO usuario;
    private Boolean liderGrupo;

    // Construtor que converte entidade em DTO
    public GrupoMembrosDTO(GrupoMembros grupoMembros) {
        if (grupoMembros != null) {
            this.id = grupoMembros.getId();
            this.liderGrupo = grupoMembros.getLiderGrupo();

            if (grupoMembros.getGrupo() != null) {
                this.grupo = new GrupoDTO(grupoMembros.getGrupo());
            }

            if (grupoMembros.getUsuario() != null) {
                this.usuario = new UsuarioDTO(grupoMembros.getUsuario());
            }
        }
    }
}
