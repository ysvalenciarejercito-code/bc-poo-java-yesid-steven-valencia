public class ServicioInterno extends ServicioBase { // 1. Uso de extends
    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10;

    public ServicioInterno(String nombre, double costoBase, String descripcion, int stockPropio) {
        super(nombre, costoBase, descripcion); // 2. Uso de super()
        this.stockPropio = stockPropio;
    }

    @Override // 3. Uso de @Override
    public double calcularCostoTotal() {
        // Accede a costoBase porque es protected en la clase padre
        return this.costoBase * (1 + MARGEN_GANANCIA);
    }
}


