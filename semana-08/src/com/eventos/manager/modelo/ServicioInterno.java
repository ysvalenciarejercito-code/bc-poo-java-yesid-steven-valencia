package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;
import com.eventos.manager.interfaces.IReportable;

public class ServicioInterno extends ServicioBase implements IReportable {

    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10; // 10% de margen

    // Debe declarar la excepción del constructor padre
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

    @Override
    public void generarReporteMensual() {
        System.out.println("[REPORTE INTERNO] Ganancia esperada por " + nombre + ": $" + (costoBase * MARGEN_GANANCIA));
    }
}
