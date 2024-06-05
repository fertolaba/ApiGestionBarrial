package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer legajo;
    private String nombre;
    private String apellido;
    private String documento;
    private String password;
    private String sector;
    private int categoria;
    private Date fechaingreso;

    @OneToMany(mappedBy = "personal", cascade=CascadeType.ALL)
    private List<Reclamo> reclamos;

    public Personal() {

    }

    public Personal(Integer legajo, String nombre, String apellido, String documento, String password, String sector, int categoria, Date fechaingreso) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.password = password;
        this.sector = sector;
        this.categoria = categoria;
        this.fechaingreso = fechaingreso;
        reclamos = new ArrayList<Reclamo>();
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Date getFechaIngreso() {
        return fechaingreso;
    }

    public void setFechaIngreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
}