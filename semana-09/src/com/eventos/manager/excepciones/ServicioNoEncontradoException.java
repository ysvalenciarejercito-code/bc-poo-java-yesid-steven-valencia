package com.eventos.manager.excepciones;

import java.io.Serializable;

/**
 * Excepción de tipo Checked lanzada cuando se intenta buscar un servicio por código que no existe.
 */
public class ServicioNoEncontradoException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public ServicioNoEncontradoException(String identificador) {
        super("El servicio con identificador '" + identificador + "' no fue encontrado en el sistema.");
    }
}