package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tag")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tag implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ToString.Include
    @Column(name = "nome_tag")
    private String nome_tag;

    @ToString.Include
    @Column(name = "sigla")
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    private Questionario questionario;

}
