package com.squadmind.squad.entity;

import com.squadmind.squad.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

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

}
