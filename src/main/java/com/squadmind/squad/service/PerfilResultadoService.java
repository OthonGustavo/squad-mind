package com.squadmind.squad.service;

import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.mapper.PerfilResultadoMapper;
import com.squadmind.squad.repository.PerfilResultadoRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilResultadoService {

    @Autowired
    private PerfilResultadoRepository perfilResultadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    // --- Salvar / criar resultado ---
    public PerfilResultadoDTO salvarResultado(Long usuarioId, Long projetoId, Long questionarioId, PerfilResultadoDTO dto) {
        Usuario usuario = buscarUsuario(usuarioId);
        Projeto projeto = buscarProjeto(projetoId);
        Questionario questionario = buscarQuestionario(questionarioId);

        PerfilResultado entity = PerfilResultadoMapper.toEntity(dto);
        entity.setUsuario(usuario);
        entity.setProjeto(projeto);
        entity.setQuestionario(questionario);

        PerfilResultado saved = perfilResultadoRepository.save(entity);
        return PerfilResultadoMapper.toDTO(saved);
    }

    // --- Buscar por ID ---
    public PerfilResultadoDTO buscarPorId(Long id) {
        return PerfilResultadoMapper.toDTO(buscarResultado(id));
    }

    // --- Listar todos ---
    public List<PerfilResultadoDTO> listarTodos() {
        return perfilResultadoRepository.findAll()
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por usuário ---
    public List<PerfilResultadoDTO> listarPorUsuario(Long usuarioId) {
        return perfilResultadoRepository.findByUsuario_Id(usuarioId)
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por projeto ---
    public List<PerfilResultadoDTO> listarPorProjeto(Long projetoId) {
        return perfilResultadoRepository.findByProjeto_Id(projetoId)
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar por questionário ---
    public List<PerfilResultadoDTO> listarPorQuestionario(Long questionarioId) {
        return perfilResultadoRepository.findByQuestionario_Id(questionarioId)
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover resultado ---
    public void removerResultado(Long id) {
        perfilResultadoRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private PerfilResultado buscarResultado(Long id) {
        return perfilResultadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultado não encontrado"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    private Questionario buscarQuestionario(Long id) {
        return questionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
    }
}
