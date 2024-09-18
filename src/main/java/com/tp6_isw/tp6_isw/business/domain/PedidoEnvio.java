package com.tp6_isw.tp6_isw.business.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido_envio")
public class PedidoEnvio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_carga", nullable = false)
    private Long tipoCarga;

    @Column(name = "domicilio_retiro", nullable = false)
    private String domicilioRetiro;

    @Column(name = "referencia_retiro")
    private String referenciaRetiro;

    @Column(name = "fecha_retiro", nullable = false)
    private Date fechaRetiro;

    @Column(name = "domicilio_entrega", nullable = false)
    private String domicilioEntrega;

    @Column(name = "referencia_entrega")
    private String referenciaEntrega;

    @Column(name = "fecha_entrega", nullable = false)
    private Date fechaEntrega;

    @Column(name = "observacion")
    private String observacion;

}
