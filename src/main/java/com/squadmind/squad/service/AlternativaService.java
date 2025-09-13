package com.squadmind.squad.service;

import com.squadmind.squad.dto.AlternativaDTO;
import com.squadmind.squad.entity.Alternativa;
import com.squadmind.squad.entity.Pergunta;
import com.squadmind.squad.mapper.AlternativaMapper;
import com.squadmind.squad.repository.AlternativaRepository;
import com.squadmind.squad.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    // --- Criar alternativa ---
    public AlternativaDTO criarAlternativa(Long perguntaId, AlternativaDTO dto) {
        Pergunta pergunta = buscarPergunta(perguntaId);

        Alternativa alternativa = AlternativaMapper.toEntity(dto);
        alternativa.setPergunta(pergunta);

        Alternativa saved = alternativaRepository.save(alternativa);
        return AlternativaMapper.toDTO(saved);
    }

    // --- Buscar alternativa por ID ---
    public AlternativaDTO buscarPorId(Long id) {
        return AlternativaMapper.toDTO(buscarAlternativa(id));
    }

    // --- Listar todas as alternativas ---
    public List<AlternativaDTO> listarTodas() {
        return alternativaRepository.findAll()
                .stream()
                .map(AlternativaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover alternativa ---
    public void remover(Long id) {
        alternativaRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private Alternativa buscarAlternativa(Long id) {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alternativa não encontrada"));
    }

    private Pergunta buscarPergunta(Long id) {
        return perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
    }
}
