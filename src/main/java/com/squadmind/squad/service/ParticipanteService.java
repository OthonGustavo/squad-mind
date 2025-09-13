package com.squadmind.squad.service;

import com.squadmind.squad.dto.ParticipanteDTO;
import com.squadmind.squad.entity.Participante;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.mapper.ParticipanteMapper;
import com.squadmind.squad.repository.ParticipanteRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    // --- Adicionar usuário a um projeto ---
    public ParticipanteDTO adicionarParticipante(Long usuarioId, Long projetoId) {
        Usuario usuario = buscarUsuario(usuarioId);
        Projeto projeto = buscarProjeto(projetoId);

        Participante participante = new Participante();
        participante.setUsuario(usuario);
        participante.setProjeto(projeto);

        Participante saved = participanteRepository.save(participante);
        return ParticipanteMapper.toDTO(saved);
    }

    // --- Buscar participante por ID ---
    public ParticipanteDTO buscarPorId(Long id) {
        return ParticipanteMapper.toDTO(buscarParticipante(id));
    }

    // --- Listar todos os participantes ---
    public List<ParticipanteDTO> listarTodos() {
        return participanteRepository.findAll()
                .stream()
                .map(ParticipanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover participante ---
    public void removerParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private Participante buscarParticipante(Long id) {
        return participanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    private Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado"));
    }
}
