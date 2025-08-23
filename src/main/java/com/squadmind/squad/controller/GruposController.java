package com.squadmind.squad.controller;


import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.service.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Grupos")
public class GruposController {

    @Autowired
    private GruposService service;

    @GetMapping
    public ResponseEntity<List<Grupos>> findAll(){
        List<Grupos> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Grupos> findById(@PathVariable Long id){
        Grupos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Grupos> insert(@RequestBody Grupos obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
