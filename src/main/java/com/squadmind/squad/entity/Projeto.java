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
@Table(name = "TB_PROJETO")
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

    public Projeto(int id, String nome, String codigoAcesso) {
        this.id = id;
        this.nome = nome;
        this.codigoAcesso = codigoAcesso;
    }

    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Usuario coordenador;

    @OneToMany(mappedBy = "projetos")
    @ToString.Exclude
    private List<Questionario> questionarios;

    @OneToMany(mappedBy = "projeto_id")
    @ToString.Exclude
    private List<PerfilResultado> perfilResultados = new ArrayList<>();

    @OneToMany(mappedBy = "projeto_id")
    @ToString.Exclude
    private List<Grupo> grupos = new ArrayList<>();

    @OneToMany(mappedBy = "projeto_id")
    @ToString.Exclude
    private  List<Participante> participantes = new ArrayList<>();

    @OneToMany(mappedBy = "projeto_id")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();

    @ManyToMany(mappedBy = "projeto_id")
    @ToString.Exclude
    private List<ProjetoQuestionario> projetoQuestionarios = new ArrayList<>();

}
