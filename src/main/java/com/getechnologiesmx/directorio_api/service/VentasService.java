package com.getechnologiesmx.directorio_api.service;

import com.getechnologiesmx.directorio_api.model.Factura;
import com.getechnologiesmx.directorio_api.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentasService {

    private final FacturaRepository facturaRepository;

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> buscarPorId(Long id) {
        return facturaRepository.findById(id);
    }
}
