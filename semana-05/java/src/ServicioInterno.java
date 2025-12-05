
/**
 * Subclase 1: Hereda de ServicioBase. Representa servicios propios de la empresa.
 * Aplica un margen de ganancia.
 */
public class ServicioInterno extends ServicioBase {

    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10; // 10% de margen

    // Constructor que usa super()
    public ServicioInterno(String nombre, double costoBase, String descripcion, int stockPropio) {
        super(nombre, costoBase, descripcion);
        this.stockPropio = stockPropio;
    }

    // @Override 1: Sobrescribe el cálculo para incluir el margen
    @Override
    public double calcularCostoTotal() {
        return this.costoBase * (1 + MARGEN_GANANCIA);
    }

    // @Override 2: Sobrescribe el detalle para incluir el stock (Ejercicio 2)
    @Override
    public String obtenerDetalle() {
        return "SERVICIO INTERNO: " + nombre + " | Stock disponible: " + stockPropio;
    }

    public int getStockPropio() {
        return stockPropio;
    }
}