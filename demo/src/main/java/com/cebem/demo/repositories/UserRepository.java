package com.cebem.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cebem.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
