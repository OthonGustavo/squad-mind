package com.squadmind.squad.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

public class PerguntasTecnicas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    private Integer questao;
    private String tipo;
    private String alternativa;
    private String descricaoPergunta;

    public PerguntasTecnicas(){

    }

    public PerguntasTecnicas(Integer questao, String tipo, String alternativa, String descricaoPergunta) {
        this.questao = questao;
        this.tipo = tipo;
        this.alternativa = alternativa;
        this.descricaoPergunta = descricaoPergunta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PerguntasTecnicas that = (PerguntasTecnicas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
