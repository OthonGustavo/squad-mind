package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Map;

@Entity
@Table(name="perfil_resultado")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PerfilResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String perfil_dominante;

    private String perfil_tecnico;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="projeto_id")
    @ToString.Exclude
    private Projeto projeto_id;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    @ToString.Exclude
    private Questionario questionario_id;

    @Convert(converter = JsonConverter.class)
    private Map<String, String> resultadoJson;

    @CreationTimestamp
    private Instant data_calculo;

    @CreationTimestamp
    private Instant data_validade;

}

