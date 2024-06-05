package com.example.demo.entity;

import com.example.demo.Views.SitioView;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sitios")
public class Sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsitio;
    private double latitud;
    private double longitud;
    private String calle;
    private int numero;
    private String entrecalleA;
    private String entrecalleB;
    private String descripcion;
    private String acargode;
    private Date apertura;
    private Date cierre;
    private String comentarios;

    public Sitio() {}

    public Sitio(Integer idsitio, double latitud, double longitud, String calle, int numero, String entrecalleA, String entrecalleB, String descripcion, String acargode, Date apertura, Date cierre, String comentarios) {
        this.idsitio = idsitio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.calle = calle;
        this.numero = numero;
        this.entrecalleA = entrecalleA;
        this.entrecalleB = entrecalleB;
        this.descripcion = descripcion;
        this.acargode = acargode;
        this.apertura = apertura;
        this.cierre = cierre;
        this.comentarios = comentarios;
    }

    public Integer getIdSitio() {
        return idsitio;
    }

    public void setIdSitio(Integer idsitio) {
        this.idsitio = idsitio;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEntreCalleA() {
        return entrecalleA;
    }

    public void setEntreCalleA(String entreCalleA) {
        this.entrecalleA = entreCalleA;
    }

    public String getEntreCalleB() {
        return entrecalleB;
    }

    public void setEntreCalleB(String entreCalleB) {
        this.entrecalleB = entreCalleB;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCargoDelSitio() {
        return acargode;
    }

    public void setCargoDelSitio(String cargoDelSitio) {
        this.acargode = cargoDelSitio;
    }

    public Date getApertura() {
        return apertura;
    }

    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }

    public Date getCierre() {
        return cierre;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public SitioView toView(){
        return new SitioView(idsitio, latitud, longitud, calle, numero, entrecalleA, entrecalleB, descripcion, acargode, apertura, cierre, comentarios);
    }


}