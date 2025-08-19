package com.squadmind.squad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class TurmaAluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    private List<Usuario> alunoId = new ArrayList<>();
    private List<Turmas> turmaId = new ArrayList<>();
    private Instant dataEntrada;

    public TurmaAluno(Long id, Instant dataEntrada) {
        this.id = id;
        this.dataEntrada = dataEntrada;
    }
}
