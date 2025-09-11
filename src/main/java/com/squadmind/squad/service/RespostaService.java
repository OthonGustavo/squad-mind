package com.squadmind.squad.service;

import com.squadmind.squad.entity.*;
import com.squadmind.squad.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;
    private final PerguntaRepository perguntaRepository;
    private final AlternativaRepository alternativaRepository;

    public RespostaService(RespostaRepository respostaRepository,
                           UsuarioRepository usuarioRepository,
                           ProjetoRepository projetoRepository,
                           PerguntaRepository perguntaRepository,
                           AlternativaRepository alternativaRepository) {
        this.respostaRepository = respostaRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
        this.perguntaRepository = perguntaRepository;
        this.alternativaRepository = alternativaRepository;
    }

    public Resposta salvarResposta(Long usuarioId,
                                   Long projetoId,
                                   Long perguntaId,
                                   Long alternativaId,
                                   Resposta resposta) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        Pergunta pergunta = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        resposta.setUsuario(usuario);
        resposta.setProjeto(projeto);
        resposta.setPergunta(pergunta);

        if (alternativaId != null) {
            Alternativa alternativa = alternativaRepository.findById(alternativaId)
                    .orElseThrow(() -> new RuntimeException("Alternativa não encontrada"));
            resposta.setAlternativa(alternativa);
        }

        return respostaRepository.save(resposta);
    }

    public Resposta buscarPorId(Long id) {
        return respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
    }

    public List<Resposta> listarTodas() {
        return respostaRepository.findAll();
    }

    public List<Resposta> listarPorUsuario(Long usuarioId) {
        return respostaRepository.findByUsuario_Id(usuarioId);
    }

    public List<Resposta> listarPorProjeto(Long projetoId) {
        return respostaRepository.findByProjeto_Id(projetoId);
    }

    public List<Resposta> listarPorPergunta(Long perguntaId) {
        return respostaRepository.findByPergunta_Id(perguntaId);
    }

    public List<Resposta> listarPorAlternativa(Long alternativaId) {
        return respostaRepository.findByAlternativa_Id(alternativaId);
    }

    public void remover(Long id) {
        respostaRepository.deleteById(id);
    }
}
