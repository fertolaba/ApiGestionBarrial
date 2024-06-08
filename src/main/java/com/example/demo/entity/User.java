package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @Column(length = 20)
    private String documento;
    private String password;

    public User() {
    }

    public User(String documento, String password) {
        this.documento = documento;
        this.password = password;
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

    public void setPassword(String password) { this.password = password; }
}

