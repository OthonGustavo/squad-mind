package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "pergunta")
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
    @ToString.Exclude
    @JoinColumn(name = "tag_id")
    private Tag tag_id;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    private Questionario questionario_id;

}
