package com.example.demo.entity;

import com.example.demo.Views.ReclamoView;
import jakarta.persistence.*;

@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreclamo;

    private String descripcion;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idreclamounificado")
    private MovimientoReclamo movimientoReclamo;

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

    public Reclamo() {}

    public Reclamo(Integer idreclamo, String descripcion, String estado, MovimientoReclamo movimientoReclamo, Vecino vecino, Sitio sitio, Desperfecto desperfecto, Personal personal) {
        this.idreclamo = idreclamo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.movimientoReclamo = movimientoReclamo;
        this.vecino = vecino;
        this.sitio = sitio;
        this.desperfecto = desperfecto;
        this.personal = personal;
    }

    public Integer getIdReclamo() {
        return idreclamo;
    }

    public void setIdReclamo(Integer idreclamo) {
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




    public MovimientoReclamo getMovimientoReclamo() {
        return movimientoReclamo;
    }

    public void setMovimientoReclamo(MovimientoReclamo movimientoReclamo) {
        this.movimientoReclamo = movimientoReclamo;
    }

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

    public ReclamoView toView(){
        return new ReclamoView(idreclamo, descripcion, estado);
    }
}