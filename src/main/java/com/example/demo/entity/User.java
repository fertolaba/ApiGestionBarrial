package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @Column(length = 40)
    private String documento;
    private String password;
    private String mail;

    private Date expiraContrasena;

    public User() {
    }

    public User(String documento, String password, String mail, Date expiraContrasena) {
        this.documento = documento;
        this.password = password;
        this.mail = mail;
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

    public Date getExpiraContrasena() {
        return expiraContrasena;
    }

    public void setExpiraContrasena(Date expiraContrasena) {
        this.expiraContrasena = expiraContrasena;
    }
}
