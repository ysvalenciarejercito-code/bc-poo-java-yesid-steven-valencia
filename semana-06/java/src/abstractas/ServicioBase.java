package abstractas;

public abstract class ServicioBase {

    // Mínimo 2 atributos protegidos
    protected String nombre;
    protected double costoBase;
    protected String descripcion;
    protected int idServicio;
    private static int contadorId = 1000;

    // Constructor que inicializa atributos
    public ServicioBase(String nombre, double costoBase, String descripcion) {
        this.nombre = nombre;
        this.costoBase = (costoBase > 0) ? costoBase : 100.0;
        this.descripcion = descripcion;
        this.idServicio = contadorId++;
    }

    // Método abstracto 1: Cálculo variable de costo
    public abstract double calcularCostoTotal();

    // Método abstracto 2: Descripción detallada variable
    public abstract String obtenerDetalleCompleto();

    // Método concreto: Comportamiento común con implementación
    public void mostrarInformacionBase() {
        System.out.println("ID Servicio: " + idServicio + " | Servicio: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Costo Base: $" + costoBase);
    }

    // Getters necesarios
    public String getNombre() { return nombre; }
    public double getCostoBase() { return costoBase; }
}