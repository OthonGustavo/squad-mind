package com.squadmind.squad.controller;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
}
