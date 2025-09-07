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

        // Limpa os dados do banco de teste antes de inserir novos
        usuarioRepository.deleteAll();

        // 1. Crie o objeto primeiro
        Usuario u1 = new Usuario();

        // 2. Use os setters para definir os valores
        u1.setNome("Maria Brown");
        u1.setEmail("maria@gmail.com");
        u1.setSenha("123456");
        u1.setTipo(UsuarioTipo.COORDENADOR);
        u1.setRegistro("PROF123");

        Usuario u2 = new Usuario();
        u2.setNome("Alex Green");
        u2.setEmail("alex@gmail.com");
        u2.setSenha("123456");
        u2.setTipo(UsuarioTipo.PARTICIPANTE);
        u2.setRegistro("ALUNO456");

        // 3. Salve o objeto usando a variável do repositório
        usuarioRepository.saveAll(Arrays.asList(u1, u2));
    }
}