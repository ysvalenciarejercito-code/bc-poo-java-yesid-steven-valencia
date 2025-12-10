public class Servicio {
    // Atributos (Mínimo 3)
    private String nombre; // Nombre del paquete o ítem (ej: "Menú Gourmet")
    private String descripcion; // Detalles del servicio ofrecido
    private double precioUnitario; // Costo por unidad o paquete
    private boolean requiereProveedorExterno; // ¿Necesita aliada externa?

    // Constructor completo
    public Servicio(String nombre, String descripcion, double precioUnitario, boolean requiereProveedorExterno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.requiereProveedorExterno = requiereProveedorExterno;
    }

    // Método de negocio: Calcula el subtotal para una cantidad dada
    /**
     * Calcula el costo de 'cantidad' unidades de este servicio.
     * @param cantidad Unidades requeridas.
     * @return El costo subtotal (precioUnitario * cantidad).
     */
    public double calcularSubtotal(int cantidad) {
        return this.precioUnitario * cantidad;
    }

    // Método de negocio: Verifica la dependencia de proveedor
    public boolean esServicioExterno() {
        return this.requiereProveedorExterno;
    }

    // Método de información (para el Main)
    public void mostrarDetalle() {
        System.out.printf("Servicio: %s | Precio: $%.2f | Externo: %s%n",
                this.nombre,
                this.precioUnitario,
                this.requiereProveedorExterno ? "Sí" : "No");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Setters
    public void setPrecioUnitario(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            this.precioUnitario = nuevoPrecio;
        }
    }
}
