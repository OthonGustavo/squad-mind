package com.squadmind.squad.controller;


import com.squadmind.squad.entity.GrupoAlunos;
import com.squadmind.squad.service.GrupoAlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/grupoAlunos")
public class GrupoAlunosController {

    @Autowired
    private GrupoAlunosService service;

    @GetMapping
    public ResponseEntity<List<GrupoAlunos>> findAll(){
        List<GrupoAlunos> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoAlunos> findById(@PathVariable Long id){
        GrupoAlunos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<GrupoAlunos> insert(@RequestBody GrupoAlunos obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
