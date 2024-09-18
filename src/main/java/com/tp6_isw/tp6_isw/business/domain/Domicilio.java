package com.tp6_isw.tp6_isw.business.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio {

    private String calle;

    private String numero;

    private String localidad;

    private String provincia;

    private String referencia;
}
