package com.example.demo.entity;


import com.example.demo.Views.VecinoView;
import jakarta.persistence.*;

@Entity
@Table(name = "vecinos")
public class Vecino {
    @Id
    @Column(length = 20)
    private String documento;
    private String nombre;
    private String apellido;
    private String direccion;

    @ManyToOne
    @JoinColumn(name="codigobarrio")
    private Barrio barrio;
    public Vecino() {
    }

    public Vecino(String documento, String nombre, String apellido, String direccion, Barrio barrio) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public VecinoView toView(){
        return new VecinoView(documento, nombre, apellido, direccion);
    }
}
