package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @Column(length = 40)
    private String identificador;
    //private String password;
    private String tipoUsuario;
    private String nombre;
    private String apellido;

    public User() {
    }

    public User(String identificador /*, String password*/, String tipoUsuario, String nombre, String apellido) {
        this.identificador = identificador;
        //this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    //public String getPassword() {  return password; }

    // public void setPassword(String password) { this.password = password; }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
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
}

