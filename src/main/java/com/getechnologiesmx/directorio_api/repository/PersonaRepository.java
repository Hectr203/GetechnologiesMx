package com.getechnologiesmx.directorio_api.repository;

import com.getechnologiesmx.directorio_api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
