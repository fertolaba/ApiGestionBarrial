package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoEnum {
    PENDIENTE("Pendiente"),
    EN_PROCESO("En revisión"),
    ANULADO("Anulado"),
    FINALIZADO("Finalizado");

    private final String estado;

    EstadoEnum(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    // Método estático para convertir String a Enum
    @JsonCreator
    public static EstadoEnum fromString(String value) {
        for (EstadoEnum estado : EstadoEnum.values()) {
            if (estado.name().equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado no válido: " + value);
    }
}