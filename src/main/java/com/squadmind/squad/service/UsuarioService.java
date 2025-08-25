package com.squadmind.squad.service;

import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TurmasRepository turmasRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, TurmasRepository turmasRepository) {
        this.usuarioRepository = usuarioRepository;
        this.turmasRepository = turmasRepository;
    }

    // Criar usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar usuário por ID
    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Criar turma para um professor
    public Turmas criarTurma(Long professorId, Turmas turma) {
        Usuario professor = usuarioRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        turma.setProfessor(professor);
        turma.setCriadoEm();
        return turmasRepository.save(turma);
    }

    // Listar turmas de um professor
    public List<Turmas> listarTurmasPorProfessor(Long professorId) {
        return turmasRepository.findByProfessorId(professorId);
    }

    public void delete(Long id){
        try {
            usuarioRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario obj){
        Usuario entity = usuarioRepository.getReferenceById(id);
        updateData(entity, obj);
        return usuarioRepository.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj) {
       entity.setNome(obj.getNome());
       entity.setSenha(obj.getSenha());
       entity.setTipo(obj.getTipo());
       entity.setRegistro(obj.getRegistro());
    }

}
