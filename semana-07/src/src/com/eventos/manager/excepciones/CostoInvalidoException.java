package com.eventos.manager.excepciones;


public class CostoInvalidoException extends Exception {

    public CostoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public CostoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}