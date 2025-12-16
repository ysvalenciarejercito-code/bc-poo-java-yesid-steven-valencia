package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;
import com.eventos.manager.interfaces.IReportable;
import java.io.Serializable;

/**
 * Representa servicios proporcionados con recursos propios (Internos).
 */
public class ServicioInterno extends ServicioBase implements IReportable {

    private static final long serialVersionUID = 1L;
    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10; // 10%

    public ServicioInterno(String nombre, double costoBase, String descripcion, int stockPropio)
            throws CostoInvalidoException {
        super(nombre, costoBase, descripcion); // Herencia: Llama al constructor padre
        this.stockPropio = stockPropio;
    }

    @Override // Polimorfismo: Sobrescritura de calcularCostoTotal()
    public double calcularCostoTotal() {
        // Aplica un margen de ganancia interno
        return this.costoBase * (1 + MARGEN_GANANCIA);
    }

    @Override // Polimorfismo: Sobrescritura de obtenerDetalleCompleto()
    public String obtenerDetalleCompleto() {
        return "TIPO: INTERNO | Stock Disponible: " + stockPropio + " | Ganancia: " + (MARGEN_GANANCIA * 100) + "%";
    }

    @Override // Implementación de IReportable
    public void generarReporteMensual() {
        System.out.println("[REPORTE INTERNO] Servicio: " + nombre + ". Stock: " + stockPropio);
    }
}