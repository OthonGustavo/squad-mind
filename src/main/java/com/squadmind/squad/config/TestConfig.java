package com.squadmind.squad.config;


import com.squadmind.squad.entities.Usuario;
import com.squadmind.squad.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "Test1", "testpwd", "aluno", "1221151824", Instant.now());
        Usuario u2 = new Usuario(null, "Test2", "pwd2", "professor", "100", Instant.now());
        Usuario u3 = new Usuario(null, "Test3", "pwd3", "professor", "500", Instant.now());
        Usuario u4 = new Usuario(null, "Test4", "pwd4", "aluno", "800", Instant.now());

        usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

    }
}
