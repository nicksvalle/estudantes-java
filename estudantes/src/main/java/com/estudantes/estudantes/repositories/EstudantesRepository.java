package com.estudantes.estudantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudantes.estudantes.entities.Estudantes;

public interface EstudantesRepository extends JpaRepository<Estudantes, Long>{
    
}
