package com.squadmind.squad.service;

import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.enums.UsuarioTipo;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.GruposRepository;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmasService {

    private final TurmasRepository turmasRepository;
    private final GruposRepository gruposRepository;

    @Autowired
    public TurmasService(TurmasRepository turmaRepository, GruposRepository grupoRepository) {
        this.turmasRepository = turmaRepository;
        this.gruposRepository = grupoRepository;
    }

    // Criar nova turma
    public Turmas criarTurma(Turmas turma) {
        turma.setCriadoEm();
        return turmasRepository.save(turma);
    }

    // Buscar turma por id
    public Turmas buscarTurma(Long id) {
        return turmasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    // Buscar todas as turmas
    public List<Turmas> listarTurmas() {
        return turmasRepository.findAll();
    }

    // Criar grupo dentro de uma turma
    public Grupos criarGrupo(Long turmaId, Grupos grupo) {
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        grupo.setTurmas(turma);
        return gruposRepository.save(grupo);
    }

    // Buscar grupos de uma turma
    public List<Grupos> listarGruposPorTurma(Long turmaId) {
        return gruposRepository.findByTurma_Id(turmaId);
    }

    public Turmas insert(Turmas obj){
        return turmasRepository.save(obj);
    }

    public void delete(Long id){
        try {
            turmasRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Turmas update(Long id, Turmas obj){
        Turmas entity = turmasRepository.getReferenceById(id);
        updateData(entity, obj);
        return turmasRepository.save(entity);
    }

    private void updateData(Turmas entity, Turmas obj) {
        entity.setNomeTurma(obj.getNomeTurma());
    }

}
