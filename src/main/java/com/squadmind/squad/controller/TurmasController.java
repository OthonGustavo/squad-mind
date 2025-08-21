package com.squadmind.squad.controller;


import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.service.TurmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmasController {

    @Autowired
    private TurmasService service;

    @GetMapping
    public ResponseEntity<List<Turmas>> findAll(){
        List<Turmas> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Turmas> findById(@PathVariable Long id){
        Turmas obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
