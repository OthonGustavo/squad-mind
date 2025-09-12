package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PERGUNTA")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pergunta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    private Questionario questionario;

    @OneToMany(mappedBy = "pergunta")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();

    @OneToMany(mappedBy = "pergunta")
    @ToString.Exclude
    private List<Alternativa> alternativas = new ArrayList<>();

    public Pergunta(Long id, String descricao, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }
}
