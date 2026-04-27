package com.cebem.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.entities.User;
import com.cebem.demo.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    
    private final UserService servicio;

    // Si uso RequiredArgsConstructor este constructor ya no es necesario
    /*public UserController(UserService servicio) {
        this.servicio = servicio;
    }*/

    @GetMapping
    List<User> obtenerTodosLosUsuarios(){ 
        // UserRepository repo = new UserRepository();        
        return servicio.getAllUsers();
        }

    @PostMapping
    User crearUsuario(@RequestBody @Valid User nuevoUsuario) {
        return servicio.guardar(nuevoUsuario);
    }    

    @DeleteMapping("/{id}") 
        void borrarUsuario(@PathVariable long id) {
            servicio.borrarUsuario(id);
    }

    @PutMapping("/{id}")
    User modificarUsuario(
        @PathVariable Long id,
        @RequestBody @Valid User usuarioActualizado) {
            return servicio.modificarUsuario(id, usuarioActualizado);
    }
}
