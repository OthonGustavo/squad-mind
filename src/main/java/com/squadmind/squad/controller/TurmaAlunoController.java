package com.squadmind.squad.controller;


import com.squadmind.squad.entity.TurmaAluno;
import com.squadmind.squad.service.TurmaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/TurmaAluno")
public class TurmaAlunoController {

    @Autowired
    private TurmaAlunoService service;

    @GetMapping
    public ResponseEntity<List<TurmaAluno>> findAll(){
        List<TurmaAluno> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaAluno> findById(@PathVariable Long id){
        TurmaAluno obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<TurmaAluno> insert(@RequestBody TurmaAluno obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
