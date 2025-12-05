public class Evento {
    // Atributos (Mínimo 5)
    private String codigo; // Identificador único del evento. (String)
    private String tipo;   // Categoría del evento (ej: boda, empresarial).
    private int asistentes; // Número de personas esperadas. (int)
    private double costoBase; // Costo inicial estimado del evento. (double)
    private boolean activo; // Estado del evento (activo/finalizado). (boolean)
    private String lugar; // Ubicación donde se realizará.

    // Constructor para inicializar atributos
    public Evento(String codigo, String tipo, int asistentes, double costoBase, String lugar) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.asistentes = asistentes;
        this.costoBase = costoBase;
        this.lugar = lugar;
        this.activo = true; // Por defecto, un evento nuevo está activo.
    }

    // 1. Metodo void que imprime información
    public void mostrarInformacion() {
        System.out.println("=== DETALLE DEL EVENTO (" + this.codigo + ") ===");
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Asistentes esperados: " + this.asistentes);
        System.out.println("Costo Base Estimado: $" + this.costoBase);
        System.out.println("Estado: " + (this.activo ? "Planificación/Activo" : "Finalizado"));
    }

    // 2. Metodo que retorna un valor calculado
    /**
     * Calcula el costo total proyectado incluyendo un 15% de gastos operativos.
     * @return El costo total con el recargo.
     */
    public double calcularCostoTotal() {
        double recargoOperativo = 0.15; // 15% de gastos operativos
        return this.costoBase * (1 + recargoOperativo);
    }

    // 3. Metodo getter
    public String getCodigo() {
        return this.codigo;
    }

    // 4. Metodo setter
    /**
     * Permite cambiar el estado del evento (Activo a Finalizado, o viceversa).
     * @param activo Nuevo estado del evento.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
        if (!activo) {
            System.out.println("-> El evento " + this.codigo + " ha sido marcado como FINALIZADO.");
        }
    }

    // Metodo extra para cumplir los 4+
    public void planificar(String detalle) {
        System.out.println("-> Iniciando planificación detallada para " + this.tipo + ": " + detalle);
    }
}