package com.example.demo.DTO;

public class DenunciaDTO {
    String documento;
    private SitioDTO sitio;
    String descripcion;
    private int aceptaresponsabilidad;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public SitioDTO getSitio() {
        return sitio;
    }

    public void setSitio(SitioDTO sitio) {
        this.sitio = sitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAceptaresponsabilidad() {
        return aceptaresponsabilidad;
    }

    public void setAceptaresponsabilidad(int aceptaresponsabilidad) {
        this.aceptaresponsabilidad = aceptaresponsabilidad;
    }
}

