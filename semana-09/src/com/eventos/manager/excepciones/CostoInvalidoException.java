package com.eventos.manager.excepciones;

import java.io.Serializable;

/**
 * Excepción de tipo Checked lanzada cuando un costo o valor monetario es inválido (<= 0).
 */
public class CostoInvalidoException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public CostoInvalidoException(String mensaje) {
        super(mensaje);
    }
}