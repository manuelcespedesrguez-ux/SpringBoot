package com.cebem.demo.services;

import com.cebem.demo.entities.User;
import com.cebem.demo.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repositorio;

    /*public UserService(UserRepository repositorio) {
        this.repositorio = repositorio;
    }*/

    public List<User> getAllUsers(){
        return repositorio.findAll();
    }

    public User guardar(User nuevoUsuario) {
        
        return repositorio.save(nuevoUsuario);
    }

    public void borrarUsuario(long id) {
        repositorio.deleteById(id);
    }

    public User modificarUsuario(Long id, User usuario) {
        Optional<User> usuarioAModificar = repositorio.findById(id);
        if (usuarioAModificar.isPresent()) {
        User usuarioOpcional = usuarioAModificar.get();
        usuarioOpcional.setEmail(usuario.getEmail());
        usuarioOpcional.setName(usuario.getName());
        // Lo vuelvo a guardar
        return repositorio.save(usuarioOpcional);
        } else {
            throw new RuntimeException("El usuario no existe");
    }
}
}
