package com.squadmind.squad.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    List<Turmas> turmas = new ArrayList<>();
    private Integer numeroGrupo;

    public Grupos(Long id, Integer numeroGrupo) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
    }

}
