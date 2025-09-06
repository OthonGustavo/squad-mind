package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "questionario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Questionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Usuario coordenador;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projetos;

}

