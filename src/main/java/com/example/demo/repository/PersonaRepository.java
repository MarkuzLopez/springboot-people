package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Persona;

/**
 * PASO 4 Crear repository, implementando interface usando JPA
 */

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
