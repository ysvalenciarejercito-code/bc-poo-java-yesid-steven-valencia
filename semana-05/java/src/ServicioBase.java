
/**
 * Clase Padre Abstracta: Define la estructura común para todos los servicios
 * contratados en un evento.
 */
public abstract class ServicioBase {

    // Atributos PROTECTED (compartidos con subclases)
    protected String nombre;
    protected double costoBase;
    protected String descripcion;

    // Constructor Completo
    public ServicioBase(String nombre, double costoBase, String descripcion) {
        this.nombre = nombre;
        // El costo debe ser positivo
        this.costoBase = (costoBase > 0) ? costoBase : 100.0;
        this.descripcion = descripcion;
    }

    // Método Heredado 1: Muestra información común (se sobrescribe en Externo)
    public void mostrarInfoBase() {
        System.out.println("--- DETALLE DEL SERVICIO ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
        System.out.println("Descripción: " + descripcion);
    }

    // Método Abstracto 1: Será sobrescrito obligatoriamente para calcular el costo real
    public abstract double calcularCostoTotal();

    // Método Base 2 (Para Sobrescritura - Ejercicio 2, Semana 05)
    public String obtenerDetalle() {
        return "Servicio Base: " + nombre + " (" + descripcion.substring(0, Math.min(descripcion.length(), 25)) + "...)";
    }

    // Getter esencial para el Main y la Gestora
    public String getNombre() {
        return nombre;
    }

    // Getter esencial para Sobrecarga
    public double getCostoBase() {
        return costoBase;
    }
}