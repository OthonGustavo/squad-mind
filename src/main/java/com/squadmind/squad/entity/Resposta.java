package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "respostas")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Resposta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer valor;

    private String respostas_texto;

    @CreationTimestamp
    private Instant data_resposta;

    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Usuario usuario_id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto_id;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta_id;

    @ManyToOne
    @JoinColumn(name = "alternativa_id")
    private Alternativa alternativa_id;

    public Resposta(Long id, Integer valor, String respostas_texto, Instant data_resposta) {
        this.id = id;
        this.valor = valor;
        this.respostas_texto = respostas_texto;
        this.data_resposta = data_resposta;
    }

}
