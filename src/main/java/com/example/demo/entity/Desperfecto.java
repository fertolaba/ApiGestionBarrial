package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "desperfectos")
public class Desperfecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddesperfecto;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idrubro")
    private Rubro rubro;

    public Desperfecto() {

    }

    public Desperfecto(Integer iddesperfecto, String descripcion, Rubro rubro) {
        this.iddesperfecto = iddesperfecto;
        this.descripcion = descripcion;
        this.rubro = rubro;
    }

    public Integer getIdDesperfecto() {
        return iddesperfecto;
    }

    public void setIdDesperfecto(Integer idDesperfecto) {
        this.iddesperfecto = idDesperfecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
}
