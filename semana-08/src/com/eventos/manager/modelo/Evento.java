package com.eventos.manager.modelo;

import com.eventos.manager.interfaces.IContratable;
import com.eventos.manager.interfaces.IReportable;
import java.time.LocalDate;

public class Evento implements IContratable, IReportable {

    private String nombre;
    private LocalDate fecha;
    private IContratable servicioPrincipal; // Uso de Interfaz como tipo de dato

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
        return "Evento: " + nombre + " en " + fecha + ". Servicio Principal: " + servicioPrincipal.obtenerDetalleContrato();
    }

    @Override
    public void generarReporteMensual() {
        System.out.println("[REPORTE EVENTO] Fecha de ejecución: " + fecha);
    }

    public LocalDate getFecha() { return fecha; }
}