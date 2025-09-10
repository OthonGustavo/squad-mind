package com.squadmind.squad.dto;

import com.squadmind.squad.entity.PerfilResultado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilResultadoDTO {

    private int id;
    private String perfilDominante;
    private String perfilTecnico;
    private UsuarioDTO usuario;
    private ProjetoDTO projeto;
    private Map<String, String> resultadoJson;
    private Instant dataCalculo;

    public PerfilResultadoDTO(PerfilResultado perfilResultado) {
        this.id = perfilResultado.getId();
        this.perfilDominante = perfilResultado.getPerfil_dominante();
        this.perfilTecnico = perfilResultado.getPerfil_tecnico();
        this.resultadoJson = perfilResultado.getResultadoJson();
        this.dataCalculo = perfilResultado.getData_calculo();

        if (perfilResultado.getUsuario() != null) {
            this.usuario = new UsuarioDTO(perfilResultado.getUsuario());
        }
        if (perfilResultado.getProjeto_id() != null) {
            this.projeto = new ProjetoDTO(perfilResultado.getProjeto_id());
        }
    }
}