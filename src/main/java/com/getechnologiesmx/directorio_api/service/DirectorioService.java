package com.getechnologiesmx.directorio_api.service;

import com.getechnologiesmx.directorio_api.model.Persona;
import com.getechnologiesmx.directorio_api.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorioService {

    private final PersonaRepository personaRepository;

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id); // elimina también sus facturas por cascada
    }
}
