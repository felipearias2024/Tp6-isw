package com.tp6_isw.tp6_isw.util;

import com.tp6_isw.tp6_isw.business.domain.Domicilio;
import com.tp6_isw.tp6_isw.business.domain.PedidoEnvio;
import com.tp6_isw.tp6_isw.business.domain.TipoCarga;
import com.tp6_isw.tp6_isw.controller.request.PedidoEnvioRequest;

import javax.print.DocFlavor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoEnvioParser {

    public static PedidoEnvio convertDomainToEntity(PedidoEnvioRequest request) throws ParseException {
        return PedidoEnvio.builder()
                .tipoCarga(Long.valueOf(TipoCarga.valueOf(request.getTipoCarga().toUpperCase()).getValue()))
                .domicilioRetiro(getDomicilio(request.getDomicilioRetiro()))
                .fechaRetiro(convertStringToDate(request.getFechaRetiro()))
                .referenciaRetiro(request.getReferenciaRetiro())
                .domicilioEntrega(getDomicilio(request.getDomicilioEntrega()))
                .fechaEntrega(convertStringToDate(request.getFechaEntrega()))
                .referenciaEntrega(request.getReferenciaEntrega())
                .observacion(request.getObservacion())
                .build();
    };

    private static String getDomicilio(Domicilio domicilio){
        return domicilio.getCalle() + " " + domicilio.getNumero() + ", " + domicilio.getLocalidad() + ", " + domicilio.getProvincia();
    }

    public static Date convertStringToDate(String fechaStr) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.parse(fechaStr);
    }
}
