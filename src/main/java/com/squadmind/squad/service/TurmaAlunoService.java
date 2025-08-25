package com.squadmind.squad.service;

import com.squadmind.squad.entity.TurmaAluno;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.enums.UsuarioTipo;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.TurmaAlunoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaAlunoService {

    @Autowired
    TurmaAlunoRepository TurmaAlunoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<TurmaAluno> findAll(){
        return TurmaAlunoRepository.findAll();
    }

    public TurmaAluno findById(Long id){
        Optional<TurmaAluno> obj = TurmaAlunoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Turma de alunos não encontrada."));
    }

    public TurmaAluno adicionarAluno(Long turmaId, Long usuarioId){
        TurmaAluno turmaAluno = TurmaAlunoRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getTipo().equals("aluno")){
            throw new IllegalArgumentException("Usuário Informado não é aluno");
        }

        turmaAluno.setAlunoId(usuario);
        return TurmaAlunoRepository.save(turmaAluno);

    }

    public TurmaAluno insert(TurmaAluno obj){
        return TurmaAlunoRepository.save(obj);
    }

    public void delete(Long id){
        TurmaAlunoRepository.deleteById(id);
    }

}
