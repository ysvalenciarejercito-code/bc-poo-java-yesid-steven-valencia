package com.eventos.manager.excepciones;


public class ServicioNoEncontradoException extends Exception {

    public ServicioNoEncontradoException(String identificador) {
        super("El servicio con identificador '" + identificador + "' no fue encontrado en el sistema.");
    }

    public ServicioNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}