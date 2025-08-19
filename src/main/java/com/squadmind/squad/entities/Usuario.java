package com.squadmind.squad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String senha;

    @Getter @Setter
    private String tipo;

    @Getter @Setter
    private String registro;

    @Getter @Setter
    private Instant criadoEm;

    public Usuario(Long id, String nome, String senha, String tipo, String registro, Instant criadoEm) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.registro = registro;
        this.criadoEm = criadoEm;
    }

}
