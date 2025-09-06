package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name="perfil_resultado")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class PerfilResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @Convert(converter = JsonConverter.class)
    private Map<String, String> resultadoJson;

}

