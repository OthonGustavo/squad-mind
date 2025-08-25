package com.squadmind.squad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmasDTO {
    private Long id;
    private String nomeTurma;
    private String chaveEntrada;
    private Long professor; // Apenas o ID do professor
    private String criadoEm;
}