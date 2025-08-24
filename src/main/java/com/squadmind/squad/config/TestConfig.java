package com.squadmind.squad.config;


import com.squadmind.squad.entity.GrupoAlunos;
import com.squadmind.squad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TurmasRepository turmasRepository;

    @Autowired
    private TurmaAlunoRepository turmaAlunoRepository;

    @Autowired
    private GruposRepository gruposRepository;

    @Autowired
    private GrupoAlunosRepository grupoAlunosRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(grupoAlunosRepository.findAll());

    }
}
