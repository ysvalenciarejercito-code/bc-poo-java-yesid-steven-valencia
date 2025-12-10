package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;

public abstract class ServicioBase {

    protected String nombre;
    protected double costoBase;
    protected String descripcion;
    protected String codigo; // Usaremos codigo para la búsqueda

    // Contador para generar códigos de ejemplo (simulación)
    private static int contador = 1;

    // APLICACIÓN DE EXCEPCIONES CHECKED EN EL CONSTRUCTOR (Ejercicio 2)
    public ServicioBase(String nombre, double costoBase, String descripcion) throws CostoInvalidoException {

        if (costoBase <= 0) {
            // Se lanza la excepción personalizada Checked
            throw new CostoInvalidoException("El costo base del servicio '" + nombre + "' debe ser mayor a cero.");
        }

        this.nombre = nombre;
        this.costoBase = costoBase;
        this.descripcion = descripcion;
        this.codigo = "S" + String.format("%03d", contador++);
    }

    public abstract double calcularCostoTotal();
    public abstract String obtenerDetalleCompleto();

    public void mostrarInformacionBase() {
        System.out.println("ID: " + codigo + " | Servicio: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
    }

    // Getters necesarios
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getCostoBase() { return costoBase; }
}