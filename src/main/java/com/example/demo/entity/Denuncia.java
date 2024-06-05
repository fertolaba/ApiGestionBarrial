package com.example.demo.entity;

import com.example.demo.Views.DenunciaView;
import jakarta.persistence.*;

@Entity
@Table(name="denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddenuncias;
    @ManyToOne
    @JoinColumn(name = "documento")
    private Vecino vecino;
    @ManyToOne
    @JoinColumn(name = "idsitio")
    private Sitio sitio;
    private String descripcion;
    private String estado;
    private int aceptaresponsabilidad;


    public Denuncia() {

    }

    public Denuncia(Integer iddenuncias, Vecino vecino, Sitio sitio, String descripcion, String estado, int aceptaresponsabilidad) {
        this.iddenuncias = iddenuncias;
        this.vecino = vecino;
        this.sitio = sitio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.aceptaresponsabilidad = aceptaresponsabilidad;

    }

    public Integer getIdDenuncia() {
        return iddenuncias;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.iddenuncias = idDenuncia;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
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

    public DenunciaView toView(){
        return new DenunciaView(iddenuncias, descripcion, estado, aceptaresponsabilidad);
    }

}