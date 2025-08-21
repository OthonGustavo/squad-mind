package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
@EqualsAndHashCode
@NoArgsConstructor
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    List<Turmas> turmas = new ArrayList<>();

    @Column(name = "numero_grupo")
    private Integer numeroGrupo;

    public Grupos(Long id, Integer numeroGrupo) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
    }

}
