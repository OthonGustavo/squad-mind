package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_GRUPO_MEMBROS")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class GrupoMembros {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Boolean liderGrupo;
}
