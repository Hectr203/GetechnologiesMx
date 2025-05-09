package com.getechnologiesmx.directorio_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
