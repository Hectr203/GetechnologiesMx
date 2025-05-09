package com.getechnologiesmx.directorio_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apellidoPaterno;

    // Este campo es opcional
    private String apellidoMaterno;

    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas;
}
