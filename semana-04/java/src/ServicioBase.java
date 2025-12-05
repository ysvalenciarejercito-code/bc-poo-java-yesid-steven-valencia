
public abstract class ServicioBase {
    // 1. Atributos PROTECTED (compartidos con subclases)
    protected String nombre;
    protected double costoBase;
    protected String descripcion;

    // 2. Constructor Completo
    public ServicioBase(String nombre, double costoBase, String descripcion) {
        // Validaciones básicas, asumiendo que los setters de S03 garantizan la limpieza de datos
        this.nombre = nombre;
        // El costo debe ser positivo
        this.costoBase = (costoBase > 0) ? costoBase : 100.0;
        this.descripcion = descripcion;
    }

    // 3. Método Heredado 1: Muestra información común (Puede ser sobrescrito)
    public void mostrarInfoBase() {
        System.out.println("--- DETALLE DEL SERVICIO ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
        System.out.println("Descripción: " + descripcion);
    }

    // 4. Método Heredado 2: Cálculo (Será obligatorio sobrescribir en las subclases)
    // El método es 'abstract' porque la fórmula de cálculo cambia según si es interno o externo.
    // Una clase con métodos abstractos debe ser marcada como 'abstract'.
    public abstract double calcularCostoTotal();

    // Getter esencial para las subclases o demostraciones
    public String getNombre() {
        return nombre;
    }
}