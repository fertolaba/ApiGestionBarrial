package com.example.demo.entity;

public class LoginRequest {
    private String documento;
    private String password;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String identificador) {
        this.documento = identificador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
