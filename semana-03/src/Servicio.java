public class Servicio {
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private boolean requiereProveedorExterno;

    // Constructor PRINCIPAL
    public Servicio(String nombre, String descripcion, double precioUnitario, boolean requiereProveedorExterno) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecioUnitario(precioUnitario); // Llama al setter con validación
        this.requiereProveedorExterno = requiereProveedorExterno;
    }

    // Constructor SECUNDARIO (No requiere proveedor externo por defecto)
    public Servicio(String nombre, double precioUnitario) {
        this(nombre, "Sin descripción detallada", precioUnitario, false);
    }

    // Método de negocio
    public double calcularSubtotal(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        return this.precioUnitario * cantidad;
    }

    // Método de negocio
    public boolean esServicioExterno() {
        return this.requiereProveedorExterno;
    }

    public void mostrarDetalle() {
        System.out.printf("Servicio: %s | Precio: $%.2f | Externo: %s%n",
                this.nombre,
                this.precioUnitario,
                this.requiereProveedorExterno ? "Sí" : "No");
    }

    // --- GETTERS ---
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public boolean isRequiereProveedorExterno() { return requiereProveedorExterno; }

    // --- SETTERS con VALIDACIÓN ---
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del servicio no puede ser vacío.");
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            this.descripcion = "N/A";
        } else {
            this.descripcion = descripcion;
        }
    }

    // Validación: Precio debe ser positivo
    public void setPrecioUnitario(double nuevoPrecio) {
        if (nuevoPrecio <= 0) {
            throw new IllegalArgumentException("El precio debe ser un valor positivo.");
        }
        this.precioUnitario = nuevoPrecio;
    }
}
