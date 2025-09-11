package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PROJETO")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Projeto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(name = "codigo_acesso")
    private String codigoAcesso;

    private Integer qtd_grupos;

    private Boolean status;

    private Instant criado_em;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Usuario coordenador;

    @OneToMany(mappedBy = "projeto")
    private List<Questionario> questionarios = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<PerfilResultado> perfilResultados = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<Grupo> grupos = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<Participante> participantes = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<Resposta> respostas = new ArrayList<>();
}
