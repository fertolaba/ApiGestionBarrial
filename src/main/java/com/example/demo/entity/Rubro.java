package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRubro;
    private String descripcion;

    public Rubro() {;
    }

    public Rubro(Integer idRubro, String descripcion) {
        this.idRubro = idRubro;
        this.descripcion = descripcion;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
