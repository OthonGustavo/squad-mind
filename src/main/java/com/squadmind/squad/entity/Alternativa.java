package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PERGUNTA")
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
    private int id;

    @Column(name = "texto")
    private String texto;
    @Column(name = "valor")
    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta_id;

    @OneToMany(mappedBy = "alternativa_id")
    @ToString.Exclude
    private List<Resposta> respostas = new ArrayList<>();

}
