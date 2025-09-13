package com.squadmind.squad.service;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.dto.ParticipanteDTO;
import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.mapper.UsuarioMapper;
import com.squadmind.squad.mapper.ParticipanteMapper;
import com.squadmind.squad.mapper.GrupoMembrosMapper;
import com.squadmind.squad.mapper.PerfilResultadoMapper;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar usuário
    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        // Converter DTO para entidade
        Usuario usuario = UsuarioMapper.toEntity(dto);

        // Salvar entidade
        Usuario saved = usuarioRepository.save(usuario);

        // Converter de volta para DTO
        return UsuarioMapper.toDTO(saved);
    }


    // Buscar usuário por ID
    public UsuarioDTO buscarPorId(Long id) {
        return UsuarioMapper.toDTO(buscarUsuario(id));
    }

    // Listar todos os usuários
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar participações do usuário (DTO)
    public List<ParticipanteDTO> listarParticipacoes(Long usuarioId) {
        Usuario usuario = buscarUsuario(usuarioId);
        return usuario.getParticipantes()
                .stream()
                .map(ParticipanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar grupos do usuário (DTO)
    public List<GrupoMembrosDTO> listarGruposDoUsuario(Long usuarioId) {
        Usuario usuario = buscarUsuario(usuarioId);
        return usuario.getGrupoMembros()
                .stream()
                .map(GrupoMembrosMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar resultados do usuário (DTO)
    public List<PerfilResultadoDTO> listarResultadosUsuario(Long usuarioId) {
        Usuario usuario = buscarUsuario(usuarioId);
        return usuario.getPerfilResultados()
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Remover usuário
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // --- Função auxiliar privada para evitar repetição ---
    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
