package com.example.demoDockerRender.controller;

import com.example.demoDockerRender.entity.Persona;
import com.example.demoDockerRender.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/create/{name}")
    public ResponseEntity<?> create(@PathVariable String name){
        return ResponseEntity.ok(
                personaRepository.save(
                        Persona.builder()
                                .name(name)
                                .build()
                )
        );
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personaRepository.findAll());
    }


}
