package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;
import com.eventos.manager.interfaces.IContratable;

// Implementa IContratable para calcularCostoTotal
public abstract class ServicioBase implements IContratable {

    protected String nombre;
    protected double costoBase;
    protected String descripcion;
    protected String codigo;

    private static int contador = 1;

    // El constructor lanza CostoInvalidoException (Checked)
    public ServicioBase(String nombre, double costoBase, String descripcion) throws CostoInvalidoException {

        if (costoBase <= 0) {
            throw new CostoInvalidoException("El costo base del servicio '" + nombre + "' debe ser mayor a cero.");
        }

        this.nombre = nombre;
        this.costoBase = costoBase;
        this.descripcion = descripcion;
        this.codigo = "S" + String.format("%03d", contador++);
    }

    // Método abstracto, debe ser implementado por subclases
    public abstract String obtenerDetalleCompleto();

    public void mostrarInformacionBase() {
        System.out.println("ID: " + codigo + " | Servicio: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
    }

    // Getters necesarios para Semana 08
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getCostoBase() { return costoBase; }

    // Setter de código (Añadido para el caso de prueba de duplicados en Main, aunque no es ideal en producción)
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @Override
    public String obtenerDetalleContrato() {
        return obtenerDetalleCompleto() + " | Costo Total: " + calcularCostoTotal();
    }
}
