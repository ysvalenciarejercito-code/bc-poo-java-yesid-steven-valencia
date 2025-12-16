package com.eventos.manager.interfaces;

/**
 * Interfaz que define las operaciones relacionadas con el costo y el detalle del contrato.
 */
public interface IContratable {

    double calcularCostoTotal();

    String obtenerDetalleContrato();
}