package com.example.demo.Views;

public class DenunciaView {
    private int iddenuncias;

    private String descripcion;

    private String estado;
    private int aceptaresponsabilidad;

    public DenunciaView() {

    }

    public DenunciaView(int iddenuncias, String descripcion, String estado, int aceptaresponsabilidad) {
        this.iddenuncias = iddenuncias;
        this.descripcion = descripcion;
        this.estado = estado;
        this.aceptaresponsabilidad = aceptaresponsabilidad;
    }

    public int getIdDenuncia() {
        return iddenuncias;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.iddenuncias = idDenuncia;
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

    public int getAceptaResponsabilidad() {
        return aceptaresponsabilidad;
    }

    public void setAceptaResponsabilidad(int aceptaResponsabilidad) {
        this.aceptaresponsabilidad = aceptaResponsabilidad;
    }
}
