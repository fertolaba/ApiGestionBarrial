package com.example.demo.entity;

import com.example.demo.Views.SitioView;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;


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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",timezone = "America/Argentina/Buenos_Aires")
    private String apertura;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",  timezone = "America/Argentina/Buenos_Aires")
    private String cierre;
    private String comentarios;
    private String documento;

    public Sitio() {}

    public Sitio(Integer idsitio, double latitud, double longitud, String calle, int numero, String entrecalleA, String entrecalleB, String descripcion, String acargode, String apertura, String cierre, String comentarios, String documento) {
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
        this.documento = documento;
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

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getCierre() {
        return cierre;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}