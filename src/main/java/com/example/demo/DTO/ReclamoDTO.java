package com.example.demo.DTO;

public class ReclamoDTO {
    private String documento;
    private Integer idsitio;
    private String descripcion;
    private DesperfectoDTO iddesperfecto;
    private int idReclamoUnificado;
    private int legajo;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getIdsitio() {
        return idsitio;
    }

    public void setIdsitio(Integer idsitio) {
        this.idsitio = idsitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getIdReclamoUnificado() {
        return idReclamoUnificado;
    }

    public void setIdReclamoUnificado(int idReclamoUnificado) {
        this.idReclamoUnificado = idReclamoUnificado;
    }
}
