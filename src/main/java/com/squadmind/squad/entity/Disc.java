package com.squadmind.squad.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Disc implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "respostas")
    @Getter @Setter
    private Long id;

    @Getter @Setter
    String descricao;

    public Disc(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}
