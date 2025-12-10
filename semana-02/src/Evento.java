// Archivo Evento.java (COMPLETO y CORREGIDO)
import java.util.ArrayList;

public class Evento {
    // ATRIBUTOS Y RELACIONES
    private String codigo;
    private String tipo;
    private int asistentes;
    private double costoBase;
    private boolean activo; // Estado del evento
    private String lugar;

    // Relaciones: Agregación/Asociación
    private Organizador organizadorAsignado;
    private Cliente clienteContratante; // Asumiendo que esta clase también está relacionada

    // Relaciones: Composición (ArrayList)
    private ArrayList<Servicio> serviciosContratados;

    // CONSTRUCTOR
    public Evento(String codigo, String tipo, int asistentes, double costoBase, String lugar, Organizador organizador) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.asistentes = asistentes;
        this.costoBase = costoBase;
        this.lugar = lugar;
        this.activo = true;

        this.organizadorAsignado = organizador;
        this.serviciosContratados = new ArrayList<>();

        // Lógica de negocio: Asigna el evento al organizador al crearlo
        if (organizador != null) {
            organizador.asignarEvento();
        }
    }

    // MÉTODO VOID (Requisito de Semana 01)

    public void mostrarInformacion() {
        System.out.println("=== DETALLE DEL EVENTO (" + this.codigo + ") ===");
        System.out.println("Tipo: " + this.tipo + " | Asistentes: " + this.asistentes);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Costo Base: $" + this.costoBase);
        System.out.println("Organizador a cargo: " + (this.organizadorAsignado != null ? this.organizadorAsignado.getNombre() : "Sin asignar"));
        System.out.println("Servicios contratados: " + this.serviciosContratados.size());
        System.out.println("Estado: " + (this.activo ? "**ACTIVO**" : "Finalizado"));
    }

    // MÉTODO QUE RETORNA VALOR CALCULADO (Requisito de Semana 01)
    public double calcularCostoTotal() {
        double recargoOperativo = 0.15; // 15% de gastos operativos
        return this.costoBase * (1 + recargoOperativo);
    }

    // MÉTODO DE NEGOCIO SEMANA 02
    public void agregarServicio(Servicio servicio, int cantidad) {
        this.serviciosContratados.add(servicio);
        System.out.printf("-> Se agregó el servicio '%s' (x%d) al Evento %s.%n",
                servicio.getNombre(), cantidad, this.codigo);
    }

    // MÉTODO DE NEGOCIO SEMANA 02
    /**
     * Calcula el número de servicios que requieren proveedor externo.
     * @return Cantidad de servicios externos.
     */
    public int contarServiciosExternos() {
        int count = 0;
        for (Servicio servicio : serviciosContratados) {
            if (servicio.esServicioExterno()) {
                count++;
            }
        }
        return count;
    }

    // GETTER (Requisito de Semana 01)
    public String getCodigo() {
        return this.codigo;
    }

    // GETTER AÑADIDO (Requisito para GestorEventos)
    public boolean isActivo() {
        return this.activo;
    }

    // SETTER (Requisito de Semana 01)
    public void setActivo(boolean activo) {
        this.activo = activo;
        if (!activo) {
            System.out.println("-> El evento " + this.codigo + " ha sido marcado como FINALIZADO.");
        }
    }
}