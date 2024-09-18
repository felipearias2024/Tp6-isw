package com.tp6_isw.tp6_isw.service;

import com.tp6_isw.tp6_isw.controller.request.PedidoEnvioRequest;

import java.text.ParseException;

public interface PedidoEnvioService {

    void crearPedidoEnvio(PedidoEnvioRequest request) throws ParseException;
}
