package com.squadmind.squad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projeto")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter
public class Projeto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String codigoAcesso;
    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Usuario coordenador;

    @OneToMany(mappedBy = "projetos")
    private List<Questionario> questionarios;

}
