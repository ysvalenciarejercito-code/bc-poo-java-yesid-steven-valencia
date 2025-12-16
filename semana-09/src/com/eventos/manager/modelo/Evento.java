package com.eventos.manager.modelo;

import com.eventos.manager.interfaces.IContratable;
import com.eventos.manager.interfaces.IReportable;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * Clase Evento, que encapsula una fecha y un servicio principal (Polimorfismo).
 */
public class Evento implements IContratable, IReportable, Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private LocalDate fecha;
    // Polimorfismo: Uso de la Interfaz como tipo de dato
    private IContratable servicioPrincipal;

    public Evento(String nombre, LocalDate fecha, IContratable servicioPrincipal) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.servicioPrincipal = servicioPrincipal;
    }

    @Override
    public double calcularCostoTotal() {
        return servicioPrincipal.calcularCostoTotal();
    }

    @Override
    public String obtenerDetalleContrato() {
        // Delega la responsabilidad al objeto IContratable contenido
        return "Evento: " + nombre + " en " + fecha + ". Servicio Principal: " + servicioPrincipal.obtenerDetalleContrato();
    }

    @Override
    public void generarReporteMensual() {
        System.out.println("[REPORTE EVENTO] Fecha de ejecución: " + fecha);
    }

    public LocalDate getFecha() { return fecha; }
}