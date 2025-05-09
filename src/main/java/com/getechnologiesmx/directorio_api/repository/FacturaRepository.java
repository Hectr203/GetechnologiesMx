package com.getechnologiesmx.directorio_api.repository;

import com.getechnologiesmx.directorio_api.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
