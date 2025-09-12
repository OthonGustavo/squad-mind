package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Alternativa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlternativaDTO {

    private Long id;
    private String texto;
    private Integer valor;
    private PerguntaDTO pergunta;
    private List<RespostaDTO> respostas;

    // Construtor que converte entidade em DTO
    public AlternativaDTO(Alternativa alternativa) {
        if (alternativa != null) {
            this.id = alternativa.getId();
            this.texto = alternativa.getTexto();
            this.valor = alternativa.getValor();

            if (alternativa.getPergunta() != null) {
                this.pergunta = new PerguntaDTO(alternativa.getPergunta());
            }

            if (alternativa.getRespostas() != null && !alternativa.getRespostas().isEmpty()) {
                this.respostas = alternativa.getRespostas().stream()
                        .map(RespostaDTO::new)
                        .collect(Collectors.toList());
            }
        }
    }
}
