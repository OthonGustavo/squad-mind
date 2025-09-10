package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "projeto_questionario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class ProjetoQuestionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @ManyToMany
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projeto_id = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "questionario_id")
    private List<Questionario> questionario_id = new ArrayList<>();

    public ProjetoQuestionario(Long id) {
        this.id = id;
    }
}
