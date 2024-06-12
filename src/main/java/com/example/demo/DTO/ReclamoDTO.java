package com.example.demo.DTO;

public class ReclamoDTO {
    private String documento;
    private int idsitio;
    private String descripcion;
    private DesperfectoDTO iddesperfecto;
    private int legajo;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdsitio() {
        return idsitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdsitio(int idsitio) {
        this.idsitio = idsitio;
    }

    public DesperfectoDTO getIddesperfecto() {
        return iddesperfecto;
    }

    public void setIddesperfecto(DesperfectoDTO iddesperfecto) {
        this.iddesperfecto = iddesperfecto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}
