package com.tp6_isw.tp6_isw.controller.request;

import com.tp6_isw.tp6_isw.business.domain.Domicilio;
import com.tp6_isw.tp6_isw.business.domain.Foto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoEnvioRequest {

    private String tipoCarga;

    private Domicilio domicilioRetiro;

    private String fechaRetiro;

    private String referenciaRetiro;

    private Domicilio domicilioEntrega;

    private String fechaEntrega;

    private String referenciaEntrega;

    private String observacion;

    private List<Foto> fotos;
}
