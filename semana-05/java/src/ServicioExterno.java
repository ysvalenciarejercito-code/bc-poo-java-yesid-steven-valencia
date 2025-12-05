
public class ServicioExterno extends ServicioBase {

    private String proveedor;
    private static final double RECARGO_GESTION = 0.05; // 5% de recargo por coordinación

    // Constructor que usa super()
    public ServicioExterno(String nombre, double costoBase, String descripcion, String proveedor) {
        super(nombre, costoBase, descripcion);
        this.proveedor = proveedor;
    }

    // @Override 1: Sobrescribe el cálculo para incluir el recargo
    @Override
    public double calcularCostoTotal() {
        return this.costoBase * (1 + RECARGO_GESTION);
    }

    // @Override 2: Sobrescribe el detalle para incluir el proveedor (Ejercicio 2)
    @Override
    public String obtenerDetalle() {
        return "SERVICIO CONTRATADO: " + nombre + " | Proveedor: " + proveedor;
    }

    // Sobreescritura opcional del método de mostrar info
    @Override
    public void mostrarInfoBase() {
        super.mostrarInfoBase();
        System.out.println("Proveedor Asignado: " + this.proveedor);
    }
}