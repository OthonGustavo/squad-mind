package com.squadmind.squad.controller;


import com.squadmind.squad.entity.Respostas;
import com.squadmind.squad.service.RespostasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostasController {

    @Autowired
    private RespostasService service;

    @GetMapping
    public ResponseEntity<List<Respostas>> findAll(){
        List<Respostas> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Respostas> findById(@PathVariable Long id){
        Respostas obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Respostas> insert(@RequestBody Respostas obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
