package com.example.demo.DTO;

import com.example.demo.entity.Personal;
import com.example.demo.entity.Reclamo;
import com.example.demo.enums.EstadoEnum;

public class ActualizarEstadoReclamoDTO {
    private Reclamo reclamo;
    private EstadoEnum estado;
    private int legajo; //

    public ActualizarEstadoReclamoDTO(Reclamo reclamo, EstadoEnum estado, int legajo) {
        this.reclamo = reclamo;
        this.estado = estado;
        this.legajo = legajo;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }


    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}
