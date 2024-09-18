package com.tp6_isw.tp6_isw.business.domain;

public enum TipoCarga {

    DOCUMENTACION(1),
    GRANOS(2),
    PAQUETE(3),
    HACIENDA(4);

    private final int value;

    TipoCarga(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
