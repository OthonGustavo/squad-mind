package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Resposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {

    private Long id;
    private Integer valor;
    private String respostaTexto;
    private Instant dataResposta;
    private UsuarioDTO usuario;
    private ProjetoDTO projeto;
    private PerguntaDTO pergunta;
    private AlternativaDTO alternativa;

    // Construtor que converte entidade em DTO
    public RespostaDTO(Resposta resposta) {
        if (resposta != null) {
            this.id = resposta.getId();
            this.valor = resposta.getValor();
            this.respostaTexto = resposta.getRespostaTexto();
            this.dataResposta = resposta.getDataResposta();

            if (resposta.getUsuario() != null) {
                this.usuario = new UsuarioDTO(resposta.getUsuario());
            }

            if (resposta.getProjeto() != null) {
                this.projeto = new ProjetoDTO(resposta.getProjeto());
            }

            if (resposta.getPergunta() != null) {
                this.pergunta = new PerguntaDTO(resposta.getPergunta());
            }

            if (resposta.getAlternativa() != null) {
                this.alternativa = new AlternativaDTO(resposta.getAlternativa());
            }
        }
    }
}
