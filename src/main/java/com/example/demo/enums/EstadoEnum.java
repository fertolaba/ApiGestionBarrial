package com.example.demo.enums;

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
}