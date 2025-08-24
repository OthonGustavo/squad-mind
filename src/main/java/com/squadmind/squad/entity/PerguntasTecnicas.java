package com.squadmind.squad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class PerguntasTecnicas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ToString.Include
    private Long id;

    @ToString.Include
    @Getter @Setter
    private Integer questao;

    @ToString.Include
    private String tipo;
    @ToString.Include
    private String alternativa;

    @Getter @Setter
    @ToString.Include
    private String descricaoPergunta;

    public PerguntasTecnicas(Integer questao, String tipo, String alternativa, String descricaoPergunta) {
        this.questao = questao;
        this.tipo = tipo;
        this.alternativa = alternativa;
        this.descricaoPergunta = descricaoPergunta;
    }

}
