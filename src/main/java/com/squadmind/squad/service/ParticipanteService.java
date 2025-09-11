package com.squadmind.squad.service;

import com.squadmind.squad.entity.Participante;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.repository.ParticipanteRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private ParticipanteRepository participanteRepository;
    private UsuarioRepository usuarioRepository;
    private ProjetoRepository projetoRepository;

    // Adicionar usuário a um projeto
    public Participante adicionarParticipante(Long usuarioId, Long projetoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Participante participante = new Participante();
        participante.setUsuario(usuario);
        participante.setProjeto(projeto);

        return participanteRepository.save(participante);
    }

    // Buscar participante por ID
    public Participante buscarPorId(Long id) {
        return participanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
    }

    // Listar todos os participantes
    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }

    // Remover participante
    public void removerParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

}

