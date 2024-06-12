package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="movimientosreclamo")
public class MovimientoReclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmovimiento;
    @ManyToOne
    @JoinColumn(name = "idreclamo")
    private Reclamo reclamo;
    private String responsable;
    private String causa;
    private LocalDateTime fecha;

    public MovimientoReclamo() {

    }

    public MovimientoReclamo(Integer idmovimiento, Reclamo reclamo, String responsable, String causa, LocalDateTime  fecha) {
        this.idmovimiento = idmovimiento;
        this.reclamo = reclamo;
        this.responsable = responsable;
        this.causa = causa;
        this.fecha = fecha;
    }

    public Integer getIdMovimiento() {
        return idmovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idmovimiento = idMovimiento;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDateTime  getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime  fecha) {
        this.fecha = fecha;
    }
}
