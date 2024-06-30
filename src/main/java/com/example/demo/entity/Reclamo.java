package com.example.demo.entity;

import com.example.demo.Views.ReclamoView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreclamo")
    private Integer idreclamo;

    private String descripcion;
    private String estado;

    // Corrección del tipo de dato para reclamoUnificado
    @ManyToOne
    @JoinColumn(name = "idreclamounificado")
    @JsonBackReference
    private Reclamo reclamoUnificado;

//    @ManyToOne
//    @JoinColumn(name = "idmovimiento")
//    private MovimientoReclamo movimientoReclamo;

    @ManyToOne
    @JoinColumn(name = "documento")
    private Vecino vecino;

    @ManyToOne
    @JoinColumn(name = "idsitio")
    private Sitio sitio;

    @ManyToOne
    @JoinColumn(name = "iddesperfecto")
    private Desperfecto desperfecto;

    @ManyToOne
    @JoinColumn(name = "legajo")
    private Personal personal;

    // Constructores, getters y setters omitidos para brevedad

    public Reclamo() {
    }

    public Reclamo(Integer idreclamo, String descripcion, String estado, Reclamo reclamoUnificado, /*MovimientoReclamo movimientoReclamo,*/ Vecino vecino, Sitio sitio, Desperfecto desperfecto, Personal personal) {
        this.idreclamo = idreclamo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.reclamoUnificado = reclamoUnificado;
        //this.movimientoReclamo = movimientoReclamo;
        this.vecino = vecino;
        this.sitio = sitio;
        this.desperfecto = desperfecto;
        this.personal = personal;
    }

    // Getters y setters para todos los atributos

    public Integer getIdreclamo() {
        return idreclamo;
    }

    public void setIdreclamo(Integer idreclamo) {
        this.idreclamo = idreclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reclamo getReclamoUnificado() {
        return reclamoUnificado;
    }

    public void setReclamoUnificado(Reclamo reclamoUnificado) {
        this.reclamoUnificado = reclamoUnificado;
    }

//    public MovimientoReclamo getMovimientoReclamo() {
//        return movimientoReclamo;
//    }
//
//    public void setMovimientoReclamo(MovimientoReclamo movimientoReclamo) {
//        this.movimientoReclamo = movimientoReclamo;
//    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public Desperfecto getDesperfecto() {
        return desperfecto;
    }

    public void setDesperfecto(Desperfecto desperfecto) {
        this.desperfecto = desperfecto;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
