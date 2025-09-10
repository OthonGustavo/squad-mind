package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_GRUPO_MEMBROS")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter
public class GrupoMembros {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="grupo_id")
    private Grupo grupo_id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario_id;

    @Column(name = "lider_grupo")
    private Boolean lider_grupo;

    public GrupoMembros(int id, Boolean lider_grupo) {
        this.id = id;
        this.lider_grupo = lider_grupo;
    }

}
