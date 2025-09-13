package com.squadmind.squad.service;

import com.squadmind.squad.dto.TipoDTO;
import com.squadmind.squad.entity.Tipo;
import com.squadmind.squad.mapper.TipoMapper;
import com.squadmind.squad.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    // Criar tipo
    public TipoDTO criarTipo(TipoDTO dto) {
        Tipo tipo = TipoMapper.toEntity(dto);
        Tipo saved = tipoRepository.save(tipo);
        return TipoMapper.toDTO(saved);
    }

    // Buscar tipo por ID
    public TipoDTO buscarPorId(Long id) {
        Tipo tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
        return TipoMapper.toDTO(tipo);
    }

    // Listar todos os tipos
    public List<TipoDTO> listarTodos() {
        return tipoRepository.findAll()
                .stream()
                .map(TipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Remover tipo
    public void removerTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}
