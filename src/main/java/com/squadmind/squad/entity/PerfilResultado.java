package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Map;

@Entity
@Table(name="TB_PERFIL_RESULTADO")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PerfilResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfil_dominante")
    private String perfilDominante;

    @Column(name = "perfil_tecnico")
    private String perfilTecnico;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="projeto_id")
    @ToString.Exclude
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    @ToString.Exclude
    private Questionario questionario;

    @Convert(converter = JsonConverter.class)
    @Column(name = "resultado_json")
    private Map<String, String> resultadoJson;

    @CreationTimestamp
    @Column(name = "data_calculo")
    private Instant dataCalculo;

    @CreationTimestamp
    @Column(name = "data_validade")
    private Instant dataValidade;

    public PerfilResultado(Long id, String perfilDominante, String perfilTecnico, Instant dataCalculo, Instant dataValidade) {
        this.id = id;
        this.perfilDominante = perfilDominante;
        this.perfilTecnico = perfilTecnico;
        this.dataCalculo = dataCalculo;
        this.dataValidade = dataValidade;
    }
}
