package com.squadmind.squad.service;

import com.squadmind.squad.entity.GrupoAlunos;
import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.GrupoAlunosRepository;
import com.squadmind.squad.repository.GruposRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoAlunosService {

    private final GrupoAlunosRepository grupoAlunosRepository;
    private final UsuarioRepository usuarioRepository;
    private final GruposRepository grupoRepository;

    @Autowired
    public GrupoAlunosService(GrupoAlunosRepository grupoAlunosRepository,
                              UsuarioRepository usuarioRepository,
                              GruposRepository grupoRepository) {
        this.grupoAlunosRepository = grupoAlunosRepository;
        this.usuarioRepository = usuarioRepository;
        this.grupoRepository = grupoRepository;
    }

    // Adicionar aluno a um grupo
    public GrupoAlunos adicionarAlunoAoGrupo(Long alunoId, Long grupoId, String registroAluno) {
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Grupos grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        // Evitar duplicidade
        boolean jaExiste = grupoAlunosRepository.existsByAluno_IdAndGrupo_Alunos_Id(alunoId, grupoId);
        if (jaExiste) {
            throw new RuntimeException("Aluno já está nesse grupo");
        }

        GrupoAlunos grupoAluno = new GrupoAlunos();
        grupoAluno.setAluno(aluno);
        grupoAluno.setGrupo_alunos(grupo);
        grupoAluno.setRegistroAluno(registroAluno);

        return grupoAlunosRepository.save(grupoAluno);
    }

    // Listar todos os alunos de um grupo
    public List<GrupoAlunos> listarAlunosDoGrupo(Long grupoId) {
        return grupoAlunosRepository.findByGrupo_Alunos_Id(grupoId);
    }

    // Listar todos os grupos de um aluno
    public List<GrupoAlunos> listarGruposDoAluno(Long alunoId) {
        return grupoAlunosRepository.findByAluno_Id(alunoId);
    }

    // Remover aluno de um grupo
    public void removerAlunoDoGrupo(Long alunoId, Long grupoId) {
        GrupoAlunos grupoAluno = grupoAlunosRepository.findByAluno_IdAndGrupo_Alunos_Id(alunoId, grupoId)
                .orElseThrow(() -> new RuntimeException("Aluno não está neste grupo"));
        grupoAlunosRepository.delete(grupoAluno);
    }


}
