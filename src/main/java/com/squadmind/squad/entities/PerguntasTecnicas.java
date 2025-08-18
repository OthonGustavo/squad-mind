package com.squadmind.squad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class PerguntasTecnicas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Integer questao;

    private String tipo;
    private String alternativa;

    @Getter @Setter
    private String descricaoPergunta;

    public PerguntasTecnicas(Integer questao, String tipo, String alternativa, String descricaoPergunta) {
        this.questao = questao;
        this.tipo = tipo;
        this.alternativa = alternativa;
        this.descricaoPergunta = descricaoPergunta;
    }

}
