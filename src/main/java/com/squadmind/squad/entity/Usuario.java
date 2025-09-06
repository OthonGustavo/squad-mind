package com.squadmind.squad.entity;

import com.squadmind.squad.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private UsuarioTipo tipo;

    @Column(name = "registro")
    private String registro;

    @CreationTimestamp
    @Column(name = "criado_em")
    private Instant criadoEm;

    @CreationTimestamp
    @Column(name = "alterado_em")
    private Instant alteradoEm;

    @OneToMany(mappedBy = "mediador_id")
    @ToString.Exclude
    private List<Projeto> projetos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_id")
    @ToString.Exclude
    private List<Participante> participantes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_id")
    @ToString.Exclude
    private List<GrupoMembros> grupoMembros = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_id")
    @ToString.Exclude
    private List<PerfilResultado> perfilResultados = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_id")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();

}
