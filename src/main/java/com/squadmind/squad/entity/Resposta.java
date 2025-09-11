package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TB_RESPOSTA")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Resposta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer valor;

    @Column(name = "resposta_texto")
    private String respostaTexto;

    @CreationTimestamp
    @Column(name = "data_resposta")
    private Instant dataResposta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    @ManyToOne
    @JoinColumn(name = "alternativa_id")
    private Alternativa alternativa;

    public Resposta(Long id, Integer valor, String respostaTexto, Instant dataResposta) {
        this.id = id;
        this.valor = valor;
        this.respostaTexto = respostaTexto;
        this.dataResposta = dataResposta;
    }
}
