
public class ServicioExterno extends ServicioBase {
    // Atributo específico de esta subclase
    private String proveedor;
    private static final double RECARGO_GESTION = 0.05; // 5% de recargo por gestión

    // Constructor: Debe usar super() para llamar al constructor del padre
    public ServicioExterno(String nombre, double costoBase, String descripcion, String proveedor) {
        super(nombre, costoBase, descripcion); // Llama al constructor de ServicioBase
        this.proveedor = proveedor;
    }

    // @Override: Sobrescribe el método abstracto del padre
    @Override
    public double calcularCostoTotal() {
        // Costo Total = CostoBase + (CostoBase * Recargo Gestión)
        return this.costoBase * (1 + RECARGO_GESTION);
    }

    // @Override: Opcionalmente, sobrescribimos el método heredado para añadir un detalle específico
    @Override
    public void mostrarInfoBase() {
        super.mostrarInfoBase(); // Reutiliza el código del padre
        System.out.println("Tipo de Gestión: TERCERO");
        System.out.println("Proveedor Asignado: " + this.proveedor);
    }
}