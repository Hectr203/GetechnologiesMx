package com.getechnologiesmx.directorio_api.controller;

import com.getechnologiesmx.directorio_api.model.Factura;
import com.getechnologiesmx.directorio_api.model.Persona;
import com.getechnologiesmx.directorio_api.service.DirectorioService;
import com.getechnologiesmx.directorio_api.service.VentasService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DirectorioRestService {

    private final DirectorioService directorioService;
    private final VentasService ventasService;
    private final Logger logger = LoggerFactory.getLogger(DirectorioRestService.class);

    // PERSONAS




    @PostMapping("/personas")
    public Persona crearPersona(@Valid @RequestBody Persona persona) {
        logger.info("Creando persona: {}", persona);
        return directorioService.guardarPersona(persona);
    }
    
        

    @GetMapping("/personas")
    public List<Persona> listarPersonas() {
        return directorioService.obtenerTodas();
    }

    @DeleteMapping("/personas/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        logger.info("Eliminando persona con id: {}", id);
        directorioService.eliminarPersona(id);
    }

    // FACTURAS

    @PostMapping("/facturas")
    public Factura crearFactura(@RequestBody Factura factura) {
        logger.info("Creando factura: {}", factura);
        return ventasService.guardarFactura(factura);
    }

    @GetMapping("/facturas")
    public List<Factura> listarFacturas() {
        return ventasService.obtenerTodas();
    }
}
