package com.eventos.manager.excepciones;

/**
 * Excepción lanzada cuando un costo o valor monetario es inválido (<= 0). (Checked Exception)
 */
public class CostoInvalidoException extends Exception {

    public CostoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public CostoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}