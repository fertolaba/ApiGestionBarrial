package com.example.demo.DTO;

public class DenunciaDTO {
    String documento;
    int idsitio;
    String descripcion;
    private int aceptaresponsabilidad;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdsitio() {
        return idsitio;
    }

    public void setIdsitio(int idsitio) {
        this.idsitio = idsitio;
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

