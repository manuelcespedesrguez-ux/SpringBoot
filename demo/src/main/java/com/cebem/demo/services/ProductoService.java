package com.cebem.demo.services;

import com.cebem.demo.entities.Producto;
import com.cebem.demo.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repositorio;

    public List<Producto> obtenerTodos() {
        return repositorio.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Producto guardar(Producto nuevoProducto) {
        return repositorio.save(nuevoProducto);
    }

    public Producto modificar(Long id, Producto productoActualizado) {
        return repositorio.findById(id).map(p -> {
            p.setNombre(productoActualizado.getNombre());
            p.setDescripcion(productoActualizado.getDescripcion());
            p.setPrecio(productoActualizado.getPrecio());
            return repositorio.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public void borrar(Long id) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("No se puede borrar: El producto no existe");
        }
        repositorio.deleteById(id);
    }
}