package com.example.demo.entity;

import com.example.demo.entity.Denuncia;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Vecino;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotificacion")
    private Integer idnotificacion;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento")
    private Vecino vecino;

    private Date fecha;

    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "iddenuncias", nullable = true)
    private Denuncia denuncia;

    @ManyToOne
    @JoinColumn(name = "idreclamo", nullable = true)
    private Reclamo reclamo;

    public Notificacion() {}

    public Notificacion(Vecino vecino, String mensaje, Denuncia denuncia, Reclamo reclamo) {
        this.vecino = vecino;
        this.fecha = new Date();
        this.mensaje = mensaje;
        this.denuncia = denuncia;
        this.reclamo = reclamo;
    }

    public Notificacion(Vecino vecino, Date fecha, String mensaje, Denuncia denuncia, Reclamo reclamo) {
        this.vecino = vecino;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.denuncia = denuncia;
        this.reclamo = reclamo;
    }

    // Getters and Setters
    public Integer getIdnotificacion() {
        return idnotificacion;
    }

    public void setIdnotificacion(Integer idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
