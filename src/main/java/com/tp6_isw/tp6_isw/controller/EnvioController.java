package com.tp6_isw.tp6_isw.controller;

import com.tp6_isw.tp6_isw.controller.request.PedidoEnvioRequest;
import com.tp6_isw.tp6_isw.service.PedidoEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.text.ParseException;

@RestController
@RequestMapping("/envio")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvioController {

    @Autowired
    private PedidoEnvioService pedidoEnvioService;

    @PostMapping()
    public void crearPedidoEnvio(@RequestBody PedidoEnvioRequest request) throws ParseException {
        pedidoEnvioService.crearPedidoEnvio(request);
    }

    @GetMapping()
    public String crearPedidoEnvio() throws ParseException {
        return "HOLA MUNDO";
    }
}
