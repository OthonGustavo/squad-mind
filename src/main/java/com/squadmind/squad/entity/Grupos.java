package com.squadmind.squad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
@EqualsAndHashCode
@NoArgsConstructor
public class Grupos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ToString.Include
    private Long id;

    @ToString.Include
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "turma_id")
    @JsonIgnore
    private Turmas turmas;

    @ToString.Include
    @Getter @Setter
    @Column(name = "numero_grupo")
    private Integer numeroGrupo;
    
    @OneToMany(mappedBy = "grupo_alunos")
    private List<GrupoAlunos> grupoAlunos = new ArrayList<>();

    public Grupos(Long id, Integer numeroGrupo) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
    }

}
