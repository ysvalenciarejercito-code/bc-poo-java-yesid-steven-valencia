package implementaciones;

import abstractas.ServicioBase;

public class ServicioExterno extends ServicioBase { // Extends

    private String proveedor;
    private static final double RECARGO_GESTION = 0.05; // 5% de recargo

    public ServicioExterno(String nombre, double costoBase, String descripcion, String proveedor) {
        super(nombre, costoBase, descripcion); // Llama a super()
        this.proveedor = proveedor;
    }

    // @Override: Implementa método abstracto 1
    @Override
    public double calcularCostoTotal() {
        // Aplica recargo de gestión del 5%
        return this.costoBase * (1 + RECARGO_GESTION);
    }

    // @Override: Implementa método abstracto 2
    @Override
    public String obtenerDetalleCompleto() {
        return "TIPO: EXTERNO (Contratado) | Proveedor: " + proveedor + " | Requiere seguimiento.";
    }
}


