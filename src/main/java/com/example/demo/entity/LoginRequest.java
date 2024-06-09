package com.example.demo.entity;

public class LoginRequest {
    private String identificador;
    private String password;

    public String getIdentificador() {
        return identificador;
    }

    public void setDocumento(String identificador) {
        this.identificador = identificador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
