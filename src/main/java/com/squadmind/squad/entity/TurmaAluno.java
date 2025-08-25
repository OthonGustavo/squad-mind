package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "turma_alunos")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class TurmaAluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @Getter @Setter
    private Long id;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @Getter @Setter
    private Usuario alunos;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "turma_id")
    @Getter @Setter
    private Turmas turmas;

    @ToString.Include
    @Column(name = "data_entrada")
    @CreationTimestamp
    private Instant dataEntrada;

    public TurmaAluno(Long id, Instant dataEntrada) {
        this.id = id;
        this.dataEntrada = dataEntrada;
    }

    public String getDataEntrada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return formatter.format(dataEntrada);
    }

    public void setCriadoEm() {
        this.dataEntrada = Instant.now();
    }

}
