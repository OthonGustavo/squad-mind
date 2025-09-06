package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "participante")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Participante implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @ToString.Exclude
    private Projeto projeto_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @ToString.Exclude
    private Usuario usuario_id;

    @CreationTimestamp
    private Instant data_entrada;

    public Participante(Instant data_entrada, Long id) {
        this.data_entrada = data_entrada;
        this.id = id;
    }

}
