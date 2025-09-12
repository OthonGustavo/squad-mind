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

    private Long id;
    private String perfilDominante;
    private String perfilTecnico;
    private UsuarioDTO usuario;
    private ProjetoDTO projeto;
    private QuestionarioDTO questionario;
    private Map<String, String> resultadoJson;
    private Instant dataCalculo;
    private Instant dataValidade;

    // Construtor que converte entidade em DTO
    public PerfilResultadoDTO(PerfilResultado perfilResultado) {
        if (perfilResultado != null) {
            this.id = perfilResultado.getId();
            this.perfilDominante = perfilResultado.getPerfilDominante();
            this.perfilTecnico = perfilResultado.getPerfilTecnico();
            this.resultadoJson = perfilResultado.getResultadoJson();
            this.dataCalculo = perfilResultado.getDataCalculo();
            this.dataValidade = perfilResultado.getDataValidade();

            if (perfilResultado.getUsuario() != null) {
                this.usuario = new UsuarioDTO(perfilResultado.getUsuario());
            }

            if (perfilResultado.getProjeto() != null) {
                this.projeto = new ProjetoDTO(perfilResultado.getProjeto());
            }

            if (perfilResultado.getQuestionario() != null) {
                this.questionario = new QuestionarioDTO(perfilResultado.getQuestionario());
            }
        }
    }
}
