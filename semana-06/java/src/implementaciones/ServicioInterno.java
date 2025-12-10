package implementaciones;

import abstractas.ServicioBase;

public class ServicioInterno extends ServicioBase { // Extends

    private int stockPropio;
    private static final double MARGEN_GANANCIA = 0.10;

    public ServicioInterno(String nombre, double costoBase, String descripcion, int stockPropio) {
        super(nombre, costoBase, descripcion); // Llama a super()
        this.stockPropio = stockPropio;
    }

    // @Override: Implementa método abstracto 1
    @Override
    public double calcularCostoTotal() {
        // Aplica margen de ganancia del 10%
        return this.costoBase * (1 + MARGEN_GANANCIA);
    }

    // @Override: Implementa método abstracto 2
    @Override
    public String obtenerDetalleCompleto() {
        return "TIPO: INTERNO (Propio) | Stock: " + stockPropio + " unidades disponibles.";
    }
}