package com.squadmind.squad.service;

import com.squadmind.squad.entity.TurmaAluno;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.enums.UsuarioTipo;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.TurmaAlunoRepository;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaAlunoService {

    private final TurmaAlunoRepository turmaAlunoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurmasRepository turmaRepository;

    @Autowired
    public TurmaAlunoService(TurmaAlunoRepository turmaAlunoRepository,
                             UsuarioRepository usuarioRepository,
                             TurmasRepository turmaRepository) {
        this.turmaAlunoRepository = turmaAlunoRepository;
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
    }

    // Matricular aluno em uma turma
    public TurmaAluno matricularAlunoEmTurma(Long alunoId, Long turmaId) {
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

        Turmas turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));

        TurmaAluno turmaAluno = new TurmaAluno();
        turmaAluno.setAlunos(aluno);
        turmaAluno.setTurmas(turma);
        turmaAluno.setCriadoEm(); // registra data de entrada

        return turmaAlunoRepository.save(turmaAluno);
    }

    // Listar alunos de uma turma
    public List<TurmaAluno> listarAlunosDaTurma(Long turmaId) {
        return turmaAlunoRepository.findByTurmas_Id(turmaId);
    }

    // Listar turmas de um aluno
    public List<TurmaAluno> listarTurmasDoAluno(Long alunoId) {
        return turmaAlunoRepository.findByAluno_Id(alunoId);
    }

    // Remover aluno da turma
    public void removerAlunoDaTurma(Long alunoId, Long turmaId) {
        TurmaAluno turmaAluno = turmaAlunoRepository.findByAluno_IdAndTurmas_Id(alunoId, turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Relação aluno/turma não encontrada"));
        turmaAlunoRepository.delete(turmaAluno);
    }

}
