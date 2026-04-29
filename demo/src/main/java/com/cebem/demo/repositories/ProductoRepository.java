package com.cebem.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cebem.demo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}