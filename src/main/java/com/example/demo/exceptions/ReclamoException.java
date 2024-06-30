package com.example.demo.exceptions;

public class ReclamoException extends RuntimeException {
    public ReclamoException(String message) {
        super(message);
    }

    public ReclamoException(String message, Throwable cause) {
        super(message, cause);
    }
}
