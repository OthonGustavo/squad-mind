package com.squadmind.squad.service;

import com.squadmind.squad.dto.DTOMapper;
import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    // Criar usuário
    public UsuarioDTO criarUsuario(Usuario usuario) {
        Usuario salvo = usuarioRepository.save(usuario);
        return DTOMapper.toUsuarioDTO(salvo);
    }

    // Buscar usuário por ID
    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return DTOMapper.toUsuarioDTO(usuario);
    }

    // Listar todos os usuários
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(DTOMapper::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    // Atualizar usuário
    public UsuarioDTO atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setTipo(usuarioAtualizado.getTipo());
        usuario.setRegistro(usuarioAtualizado.getRegistro());

        Usuario salvo = usuarioRepository.save(usuario);
        return DTOMapper.toUsuarioDTO(salvo);
    }

    // Deletar usuário
    public void deletarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar o usuário devido a restrições de integridade");
        }
    }
}
