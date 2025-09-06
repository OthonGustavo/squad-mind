package com.squadmind.squad.service;

import com.squadmind.squad.entity.Alternativa;
import com.squadmind.squad.entity.Pergunta;
import com.squadmind.squad.repository.AlternativaRepository;
import com.squadmind.squad.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativaService {

    private final AlternativaRepository alternativaRepository;
    private final PerguntaRepository perguntaRepository;

    public AlternativaService(AlternativaRepository alternativaRepository, PerguntaRepository perguntaRepository) {
        this.alternativaRepository = alternativaRepository;
        this.perguntaRepository = perguntaRepository;
    }

    public Alternativa criarAlternativa(Long perguntaId, Alternativa alternativa) {
        Pergunta pergunta = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        alternativa.setPergunta_id(pergunta);
        return alternativaRepository.save(alternativa);
    }

    public List<Alternativa> listarAlternativasPorPergunta(Long perguntaId) {
        return alternativaRepository.findByPergunta_id_Id(perguntaId);
    }

    public Alternativa buscarPorId(Long id) {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alternativa não encontrada"));
    }

    public List<Alternativa> listarTodas() {
        return alternativaRepository.findAll();
    }

    public void remover(Long id) {
        alternativaRepository.deleteById(id);
    }
}
