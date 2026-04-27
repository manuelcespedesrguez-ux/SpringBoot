package com.cebem.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.services.RickAndMortyService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
public class RickAndMortyController {
    
    private final RickAndMortyService servicio;

    @GetMapping("/personajes")
    public Object obtenerPersonajes() {
        return servicio.obtenerPersonajesVivos();
    }

    

}
