package com.example.demo.Views;


public class ReclamoView {
    private int idreclamo;
    private String descripcion;
    private String estado;


    public ReclamoView() {}

    public ReclamoView(int idreclamo, String descripcion, String estado) {
        this.idreclamo = idreclamo;
        this.descripcion = descripcion;
        this.estado = estado;

    }

    public int getIdReclamo() {
        return idreclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idreclamo = idReclamo;
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

}
