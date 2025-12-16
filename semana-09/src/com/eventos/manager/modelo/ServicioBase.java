package com.eventos.manager.modelo;

import com.eventos.manager.excepciones.CostoInvalidoException;
import com.eventos.manager.interfaces.IContratable;
import java.io.Serializable;

/**
 * Clase base abstracta para todos los tipos de servicios.
 * Implementa IContratable y Serializable para persistencia.
 */
public abstract class ServicioBase implements IContratable, Serializable {

    private static final long serialVersionUID = 1L;

    protected String nombre;
    protected double costoBase;
    protected String descripcion;
    protected String codigo;

    // Marcado como 'transient' para evitar su serialización. Se reinicia al cargar.
    private static transient int contador = 1;

    public ServicioBase(String nombre, double costoBase, String descripcion) throws CostoInvalidoException {

        // Encapsulación y Validación
        if (costoBase <= 0) {
            throw new CostoInvalidoException("El costo base del servicio '" + nombre + "' debe ser mayor a cero.");
        }

        this.nombre = nombre;
        this.costoBase = costoBase;
        this.descripcion = descripcion;

        // Asignación de código solo si no ha sido cargado/establecido (al deserializar no es null)
        if (this.codigo == null) {
            this.codigo = "S" + String.format("%03d", contador++);
        }
    }

    // Método abstracto (Abstracción/Polimorfismo)
    public abstract String obtenerDetalleCompleto();

    @Override // Polimorfismo: Implementación de IContratable
    public String obtenerDetalleContrato() {
        return "Contrato [" + codigo + "]: " + nombre + " | Detalle: " + obtenerDetalleCompleto() +
                " | Costo Total: $" + calcularCostoTotal();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getCostoBase() { return costoBase; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    // Setter estático para ajustar el contador al cargar datos si es necesario (opcional en esta versión)
    public static void setContador(int nuevoContador) {
        contador = nuevoContador;
    }
}