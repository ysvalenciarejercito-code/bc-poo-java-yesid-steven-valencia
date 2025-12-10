package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;

public class ServicioInterno extends ServicioBase {

    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10;

    // El constructor debe DECLARAR la excepción que lanza el padre (throws)
    public ServicioInterno(String nombre, double costoBase, String descripcion, int stockPropio)
            throws CostoInvalidoException {
        super(nombre, costoBase, descripcion);
        this.stockPropio = stockPropio;
    }

    @Override
    public double calcularCostoTotal() {
        return this.costoBase * (1 + MARGEN_GANANCIA);
    }

    @Override
    public String obtenerDetalleCompleto() {
        return "TIPO: INTERNO | Stock Disponible: " + stockPropio;
    }
}