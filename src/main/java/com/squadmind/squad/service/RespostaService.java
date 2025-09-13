package com.squadmind.squad.service;

import com.squadmind.squad.dto.RespostaDTO;
import com.squadmind.squad.entity.*;
import com.squadmind.squad.mapper.RespostaMapper;
import com.squadmind.squad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private AlternativaRepository alternativaRepository;

    public RespostaDTO salvarResposta(Long usuarioId,
                                      Long projetoId,
                                      Long perguntaId,
                                      Long alternativaId,
                                      RespostaDTO dto) {

        // Converte o DTO para a entidade
        Resposta resposta = RespostaMapper.toEntity(dto);

        // Busca entidades relacionadas
        resposta.setUsuario(buscarUsuario(usuarioId));
        resposta.setProjeto(buscarProjeto(projetoId));
        resposta.setPergunta(buscarPergunta(perguntaId));

        if (alternativaId != null) {
            resposta.setAlternativa(buscarAlternativa(alternativaId));
        }

        // Salva no repositório
        Resposta saved = respostaRepository.save(resposta);

        // Converte de volta para DTO
        return RespostaMapper.toDTO(saved);
    }


    // --- Buscar por ID ---
    public RespostaDTO buscarPorId(Long id) {
        return RespostaMapper.toDTO(buscarResposta(id));
    }

    // --- Listar todas ---
    public List<RespostaDTO> listarTodas() {
        return respostaRepository.findAll()
                .stream()
                .map(RespostaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por usuário ---
    public List<RespostaDTO> listarPorUsuario(Long usuarioId) {
        return respostaRepository.findByUsuario_Id(usuarioId)
                .stream()
                .map(RespostaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por projeto ---
    public List<RespostaDTO> listarPorProjeto(Long projetoId) {
        return respostaRepository.findByProjeto_Id(projetoId)
                .stream()
                .map(RespostaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por pergunta ---
    public List<RespostaDTO> listarPorPergunta(Long perguntaId) {
        return respostaRepository.findByPergunta_Id(perguntaId)
                .stream()
                .map(RespostaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por alternativa ---
    public List<RespostaDTO> listarPorAlternativa(Long alternativaId) {
        return respostaRepository.findByAlternativa_Id(alternativaId)
                .stream()
                .map(RespostaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover ---
    public void remover(Long id) {
        respostaRepository.deleteById(id);
    }

    // --- Métodos auxiliares privados ---
    private Resposta buscarResposta(Long id) {
        return respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    private Pergunta buscarPergunta(Long id) {
        return perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
    }

    private Alternativa buscarAlternativa(Long id) {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alternativa não encontrada"));
    }
}
