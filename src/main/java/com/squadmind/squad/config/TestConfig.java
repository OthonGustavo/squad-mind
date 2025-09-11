package com.squadmind.squad.config;

import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.enums.UsuarioTipo;
import com.squadmind.squad.repository.GrupoMembrosRepository;
import com.squadmind.squad.repository.GrupoRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Corrigi os nomes dos repositórios para os que existem no seu projeto.
    // Removi os que não estavam sendo usados para simplificar.
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoMembrosRepository grupoMembrosRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(usuarioRepository.findAll());
    }
}