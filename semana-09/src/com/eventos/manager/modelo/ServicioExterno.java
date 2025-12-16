package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;
import java.io.Serializable;

/**
 * Representa servicios contratados a proveedores externos.
 */
public class ServicioExterno extends ServicioBase {

    private static final long serialVersionUID = 1L;
    private double comision; // Porcentaje que se cobra al proveedor

    public ServicioExterno(String nombre, double costoBase, String descripcion, double comision)
            throws CostoInvalidoException {
        super(nombre, costoBase, descripcion); // Herencia: Llama al constructor padre
        this.comision = comision;
    }

    @Override // Polimorfismo: Sobrescritura de calcularCostoTotal()
    public double calcularCostoTotal() {
        // Aplica la comisión de gestión
        return this.costoBase * (1 + comision);
    }

    @Override // Polimorfismo: Sobrescritura de obtenerDetalleCompleto()
    public String obtenerDetalleCompleto() {
        return "TIPO: EXTERNO | Comisión Aplicada: " + (comision * 100) + "%";
    }
}