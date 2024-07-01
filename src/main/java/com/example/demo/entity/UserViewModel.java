package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
public class UserViewModel {
    @Id
    @Column(length = 40)
    private String documento;
    private String password;
    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String mail;
    private String rubro;
    private int legajo;
    private java.sql.Date expiraContrasena;

    public UserViewModel() {
    }

    public UserViewModel(String documento, String password, String tipoUsuario, String nombre, String apellido, String mail, String rubro, int legajo, java.sql.Date expiraContrasena) {
        this.documento = documento;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoUsuario = tipoUsuario;
        this.mail = mail;
        this.rubro = rubro;
        this.legajo = legajo;
        this.expiraContrasena = expiraContrasena;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public java.sql.Date getExpiraContrasena() {
        return expiraContrasena;
    }

    public void setExpiraContrasena(java.sql.Date expiraContrasena) {
        this.expiraContrasena = expiraContrasena;
    }
}
