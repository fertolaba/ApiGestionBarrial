package com.example.demo.DTO;
public class DenunciaRequest {
    String documento;
    private SitioRequest sitioRequest;
    String descripcion;
    private int aceptaresponsabilidad;
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public SitioRequest getSitio() {
        return sitioRequest;
    }
    public void setSitio(SitioRequest sitioRequest) {
        this.sitioRequest = sitioRequest;
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