package com.getechnologiesmx.directorio_api.controller;

import com.getechnologiesmx.directorio_api.model.Factura;
import com.getechnologiesmx.directorio_api.model.Persona;
import com.getechnologiesmx.directorio_api.service.DirectorioService;
import com.getechnologiesmx.directorio_api.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DirectorioRestService {

    @Autowired
    private DirectorioService directorioService;

    @Autowired
    private VentasService ventasService;

    // ---------------- PERSONAS ----------------

    @GetMapping("/personas")
    public List<Persona> obtenerPersonas() {
        return directorioService.obtenerTodas();
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        return directorioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/personas")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(directorioService.guardar(persona));
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        Optional<Persona> persona = directorioService.obtenerPorId(id);
        if (persona.isPresent()) {
            directorioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ---------------- FACTURAS ----------------

    @GetMapping("/facturas")
    public List<Factura> obtenerFacturas() {
        return ventasService.obtenerTodas();
    }

    @GetMapping("/personas/{id}/facturas")
    public ResponseEntity<List<Factura>> obtenerFacturasPorPersona(@PathVariable Long id) {
        return ResponseEntity.ok(ventasService.obtenerPorPersonaId(id));
    }

    @PostMapping("/facturas")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(ventasService.guardar(factura));
    }
}
