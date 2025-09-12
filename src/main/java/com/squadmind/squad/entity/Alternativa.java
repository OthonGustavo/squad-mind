package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ALTERNATIVA")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Alternativa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "valor")
    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    @OneToMany(mappedBy = "alternativa")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();
}
