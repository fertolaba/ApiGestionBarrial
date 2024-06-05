package com.example.demo.Views;

public class BarrioView {
    private int idBarrio;
    private String nombre;

    public BarrioView() {

    }

    public BarrioView(int idBarrio, String nombre) {
        this.idBarrio = idBarrio;
        this.nombre = nombre;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}