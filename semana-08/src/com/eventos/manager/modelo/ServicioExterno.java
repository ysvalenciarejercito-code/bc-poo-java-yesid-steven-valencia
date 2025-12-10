package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;

public class ServicioExterno extends ServicioBase {

    private double comision; // Porcentaje que se cobra al proveedor (ej: 0.15)

    // Debe declarar la excepción del constructor padre
    public ServicioExterno(String nombre, double costoBase, String descripcion, double comision)
            throws CostoInvalidoException {
        super(nombre, costoBase, descripcion);
        this.comision = comision;
    }

    @Override
    public double calcularCostoTotal() {
        // Costo base más la comisión de gestión
        return this.costoBase * (1 + comision);
    }

    @Override
    public String obtenerDetalleCompleto() {
        return "TIPO: EXTERNO | Comisión Aplicada: " + (comision * 100) + "%";
    }
}