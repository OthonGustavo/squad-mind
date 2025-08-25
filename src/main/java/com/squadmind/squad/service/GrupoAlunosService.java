package com.squadmind.squad.service;

import com.squadmind.squad.dto.DTOMapper;
import com.squadmind.squad.dto.GrupoAlunosDTO;
import com.squadmind.squad.entity.GrupoAlunos;
import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.GrupoAlunosRepository;
import com.squadmind.squad.repository.GruposRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoAlunosService {

    private final GrupoAlunosRepository grupoAlunosRepository;
    private final UsuarioRepository usuarioRepository;
    private final GruposRepository gruposRepository;

    @Autowired
    public GrupoAlunosService(GrupoAlunosRepository grupoAlunosRepository,
                              UsuarioRepository usuarioRepository,
                              GruposRepository gruposRepository) {
        this.grupoAlunosRepository = grupoAlunosRepository;
        this.usuarioRepository = usuarioRepository;
        this.gruposRepository = gruposRepository;
    }

    // Criar associação aluno → grupo
    public GrupoAlunosDTO criarGrupoAluno(Long alunoId, Long grupoId, String registroAluno) {
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        Grupos grupo = gruposRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado"));

        GrupoAlunos grupoAluno = new GrupoAlunos();
        grupoAluno.setAluno(aluno);
        grupoAluno.setGrupo_alunos(grupo);
        grupoAluno.setRegistroAluno(registroAluno);

        GrupoAlunos salvo = grupoAlunosRepository.save(grupoAluno);
        return DTOMapper.toGrupoAlunosDTO(salvo);
    }

    // Buscar associação por ID
    public GrupoAlunosDTO buscarGrupoAluno(Long id) {
        GrupoAlunos grupoAluno = grupoAlunosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro de grupo-aluno não encontrado"));
        return DTOMapper.toGrupoAlunosDTO(grupoAluno);
    }

    // Listar todos os registros
    public List<GrupoAlunosDTO> listarGrupoAlunos() {
        return grupoAlunosRepository.findAll()
                .stream()
                .map(DTOMapper::toGrupoAlunosDTO)
                .collect(Collectors.toList());
    }

    // Deletar associação
    public void deletarGrupoAluno(Long id) {
        try {
            grupoAlunosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Registro de grupo-aluno não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar devido a restrições de integridade");
        }
    }
}
