package com.squadmind.squad.service;

import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmasService {

    @Autowired
    TurmasRepository turmasRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Turmas> findAll(){
        return turmasRepository.findAll();
    }

    public Turmas findById(Long id){
        Optional<Turmas> obj = turmasRepository.findById(id);
        return obj.get();
    }

    public Turmas adicionarProfessor(Long turmaId, Long usuarioId){
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getTipo().equals("Professor")){
            throw new IllegalArgumentException("Usuário Informado não é professor");
        }

        turma.setProfessorId(usuario);
        return turmasRepository.save(turma);

    }

    public Turmas insert(Turmas obj){
        return turmasRepository.save(obj);
    }

    public void delete(Long id){
        turmasRepository.deleteById(id);
    }

}
