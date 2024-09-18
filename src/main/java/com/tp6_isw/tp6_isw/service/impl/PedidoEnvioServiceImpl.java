package com.tp6_isw.tp6_isw.service.impl;

import com.tp6_isw.tp6_isw.business.domain.PedidoEnvio;
import com.tp6_isw.tp6_isw.business.domain.Transportista;
import com.tp6_isw.tp6_isw.controller.request.PedidoEnvioRequest;
import com.tp6_isw.tp6_isw.repository.PedidoEnvioRepository;
import com.tp6_isw.tp6_isw.service.PedidoEnvioService;
import com.tp6_isw.tp6_isw.util.PedidoEnvioParser;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class PedidoEnvioServiceImpl implements PedidoEnvioService {

    private final PedidoEnvioRepository repository;

    private PedidoEnvioServiceImpl(PedidoEnvioRepository repository){
        this.repository = repository;
    }


    @Override
    public void crearPedidoEnvio(PedidoEnvioRequest request){
        try{
            PedidoEnvio pedidoEnvio = PedidoEnvioParser.convertDomainToEntity(request);
            validateDates(pedidoEnvio);
            repository.save(pedidoEnvio);
            notificarTransportistas(request);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void notificarTransportistas(PedidoEnvioRequest request) {
        List<String> emails = repository.findTransportistasByLocalidad(request.getDomicilioRetiro().getProvincia(), request.getDomicilioRetiro().getLocalidad(), request.getDomicilioEntrega().getLocalidad());
        enviarEmail(request, emails);
    }

    private void enviarEmail(PedidoEnvioRequest request, List<String> emails) {
        String host = "smtp.gmail.com";
        final String username = "tangoapptech@gmail.com";
        final String password = "fgrj fpnu jjqj voli";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tangoapptech@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", emails)));
            message.setSubject("Notificacion de pedido de envio");
            message.setText("Estimados Transportistas,\n" +
                    "\n" +
                    "Espero que este mensaje les encuentre bien.\n" +
                    "\n" +
                    "Nos dirigimos a ustedes para informarles que tenemos un pedido esperando a ser recogido en la siguiente ubicación:\n" +
                    "\n" +
                    "Dirección de Retiro:\n" +
                    "\n" +
                    "Calle: " + request.getDomicilioRetiro().getCalle() + "\n" +
                    "Número: " + request.getDomicilioRetiro().getNumero() + "\n" +
                    "Localidad: " + request.getDomicilioRetiro().getLocalidad() + "\n" +
                    "Provincia: " + request.getDomicilioRetiro().getProvincia() + "\n" +
                    "Referencia: " + request.getDomicilioRetiro().getReferencia() + "\n"+
                    "Por favor verificar la aplicación para confirmar el viaje");

            Transport.send(message);

            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void validateDates(PedidoEnvio pedidoEnvio) {
        if (pedidoEnvio.getFechaRetiro().before(new Date())){
            throw new RuntimeException("La fecha de retiro no puede ser anterior al dia actual");
        }
        if (pedidoEnvio.getFechaEntrega().before(new Date())){
            throw new RuntimeException("La fecha de entrega no puede ser anterior al dia actual");
        }
        if (pedidoEnvio.getFechaEntrega().before(pedidoEnvio.getFechaRetiro())){
            throw new RuntimeException("La fecha de entrega no puede ser anterior a la fecha de retiro");
        }
    }
}
