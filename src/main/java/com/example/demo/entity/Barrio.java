package com.example.demo.entity;

import com.example.demo.Views.BarrioView;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="barrios")
public class Barrio {
    @Id
    private Integer idbarrio;
    private String nombre;


    public Barrio() {

    }

    public Barrio(Integer idbarrio, String nombre, List<Vecino> vecinos) {
        this.idbarrio = idbarrio;
        this.nombre = nombre;

    }

    public Integer getIdBarrio() {
        return idbarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idbarrio = idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BarrioView toView(){
        return new BarrioView(idbarrio, nombre);
    }
}