package com.example.demo.Views;

public class VecinoView {
    private String documento;
    private String nombre;
    private String apellido;
    private String direccion;

    public VecinoView() {}

    public VecinoView(String documento, String nombre, String apellido, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
