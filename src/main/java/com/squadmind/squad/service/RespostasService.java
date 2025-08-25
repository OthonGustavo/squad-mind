package com.squadmind.squad.service;

import com.squadmind.squad.dto.DTOMapper;
import com.squadmind.squad.dto.RespostasDTO;
import com.squadmind.squad.entity.Respostas;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.RespostasRepository;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostasService {

    private final RespostasRepository respostasRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurmasRepository turmasRepository;

    @Autowired
    public RespostasService(RespostasRepository respostasRepository,
                            UsuarioRepository usuarioRepository,
                            TurmasRepository turmasRepository) {
        this.respostasRepository = respostasRepository;
        this.usuarioRepository = usuarioRepository;
        this.turmasRepository = turmasRepository;
    }

    // Criar resposta
    public RespostasDTO criarResposta(Long alunoId, Long turmaId, Respostas respostas) {
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));

        respostas.setAlunoId(aluno);
        respostas.setTurmasId(turma);

        Respostas salvo = respostasRepository.save(respostas);
        return DTOMapper.toRespostasDTO(salvo);
    }

    // Buscar resposta por ID
    public RespostasDTO buscarResposta(Long id) {
        Respostas resposta = respostasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resposta não encontrada"));
        return DTOMapper.toRespostasDTO(resposta);
    }

    // Listar todas as respostas
    public List<RespostasDTO> listarRespostas() {
        return respostasRepository.findAll()
                .stream()
                .map(DTOMapper::toRespostasDTO)
                .collect(Collectors.toList());
    }

    // Atualizar resposta
    public RespostasDTO atualizarResposta(Long id, Respostas respostasAtualizada) {
        Respostas resposta = respostasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resposta não encontrada"));

        resposta.setPontuacaoD(respostasAtualizada.getPontuacaoD());
        resposta.setPontuacaoI(respostasAtualizada.getPontuacaoI());
        resposta.setPontuacaoS(respostasAtualizada.getPontuacaoS());
        resposta.setPontuacaoC(respostasAtualizada.getPontuacaoC());
        resposta.setPerfilDominante(respostasAtualizada.getPerfilDominante());
        resposta.setRespostas_json(respostasAtualizada.getRespostas_json());

        Respostas salvo = respostasRepository.save(resposta);
        return DTOMapper.toRespostasDTO(salvo);
    }

    // Deletar resposta
    public void deletarResposta(Long id) {
        try {
            respostasRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resposta não encontrada");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar devido a restrições de integridade");
        }
    }
}
