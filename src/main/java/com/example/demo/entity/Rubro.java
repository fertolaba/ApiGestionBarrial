package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="rubros")
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrubro;
    private String descripcion;

    public Rubro() {;
    }

    public Rubro(Integer idrubro, String descripcion) {
        this.idrubro = idrubro;
        this.descripcion = descripcion;
    }

    public Integer getIdRubro() {
        return idrubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idrubro = idRubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
