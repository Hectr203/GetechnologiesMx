package com.getechnologiesmx.directorio_api.service;

import com.getechnologiesmx.directorio_api.model.Factura;
import com.getechnologiesmx.directorio_api.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerPorPersonaId(Long personaId) {
        return facturaRepository.findByPersonaId(personaId);
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }
}
