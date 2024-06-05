package com.example.demo.exceptions;

public class SitioException extends Exception {
    private static final long serialVersionUID = -2835873129858130160L;

    public SitioException(String mensaje) {
        super(mensaje);
    }
}
