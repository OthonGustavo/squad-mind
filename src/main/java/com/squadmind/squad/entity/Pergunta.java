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
    private int id;

    private String descricao;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag_id;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    private Questionario questionario_id;

    @OneToMany(mappedBy = "pergunta_id")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();

    public Pergunta(int id, String descricao, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }
}
