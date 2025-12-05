import java.util.ArrayList;

public class Evento {
    // ATRIBUTOS: Encapsulación COMPLETA
    private String codigo;
    private String tipo;
    private int asistentes;
    private double costoBase;
    private boolean activo;
    private String lugar;

    // Relaciones
    private Organizador organizadorAsignado;
    private ArrayList<Servicio> serviciosContratados;

    // --- CONSTRUCTORES SOBRECARGADOS ---

    // 1. Constructor PRINCIPAL: Completo (Usa los setters con validación)
    public Evento(String codigo, String tipo, int asistentes, double costoBase, String lugar, Organizador organizador) {
        setCodigo(codigo);
        setTipo(tipo);
        setAsistentes(asistentes); // Llama al setter con validación
        setCostoBase(costoBase);   // Llama al setter con validación
        setLugar(lugar);
        this.activo = true;
        this.organizadorAsignado = organizador;
        this.serviciosContratados = new ArrayList<>();

        // Lógica de negocio
        if (organizador != null) {
            organizador.asignarEvento();
        }
    }

    // 2. Constructor de COTIZACIÓN RÁPIDA (Sin Organizador ni Lugar)
    public Evento(String codigo, String tipo, int asistentes) {
        // Llama al constructor principal con valores por defecto
        this(codigo, tipo, asistentes, 0.0, "Pendiente de definir", null);
    }

    // 3. Constructor MÍNIMO (Solo Tipo y Asistentes)
    public Evento(String tipo, int asistentes) {
        // Genera un código temporal y usa el costo base 0.0
        this("TEMP-" + tipo.substring(0, 3).toUpperCase() + System.currentTimeMillis() % 1000,
                tipo, asistentes, 0.0, "Pendiente de definir", null);
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void mostrarInformacion() {
        System.out.println("=== DETALLE DEL EVENTO (" + this.codigo + ") ===");
        System.out.println("Tipo: " + this.tipo + " | Asistentes: " + this.asistentes);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Costo Base: $" + this.costoBase);
        System.out.println("Organizador a cargo: " + (this.organizadorAsignado != null ? this.organizadorAsignado.getNombre() : "Sin asignar"));
        System.out.println("Servicios contratados: " + this.serviciosContratados.size());
        System.out.println("Estado: " + (this.activo ? "**ACTIVO**" : "Finalizado"));
    }

    public double calcularCostoTotal() {
        double recargoOperativo = 0.15;
        return this.costoBase * (1 + recargoOperativo);
    }

    public void agregarServicio(Servicio servicio, int cantidad) {
        this.serviciosContratados.add(servicio);
        System.out.printf("-> Se agregó el servicio '%s' (x%d) al Evento %s.%n",
                servicio.getNombre(), cantidad, this.codigo);
    }

    public int contarServiciosExternos() {
        int count = 0;
        for (Servicio servicio : serviciosContratados) {
            if (servicio.esServicioExterno()) {
                count++;
            }
        }
        return count;
    }

    // --- GETTERS (Lectura) ---
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public int getAsistentes() { return asistentes; }
    public double getCostoBase() { return costoBase; }
    public boolean isActivo() { return activo; }
    public String getLugar() { return lugar; }
    public Organizador getOrganizadorAsignado() { return organizadorAsignado; }

    // --- SETTERS con VALIDACIÓN (Escritura Controlada) ---

    private void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser vacío.");
        }
        this.codigo = codigo;
    }

    private void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de evento no puede ser vacío.");
        }
        this.tipo = tipo;
    }

    // Validación: Asistentes debe ser un número positivo
    public void setAsistentes(int asistentes) {
        if (asistentes <= 0) {
            throw new IllegalArgumentException("El número de asistentes debe ser positivo.");
        }
        this.asistentes = asistentes;
    }

    // Validación: Costo debe ser positivo
    public void setCostoBase(double costoBase) {
        if (costoBase < 0) {
            throw new IllegalArgumentException("El costo base no puede ser negativo.");
        }
        this.costoBase = costoBase;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
        if (!activo) {
            System.out.println("-> El evento " + this.codigo + " ha sido marcado como FINALIZADO.");
        }
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.trim().isEmpty()) {
            throw new IllegalArgumentException("El lugar no puede ser vacío.");
        }
        this.lugar = lugar;
    }

    public void setOrganizadorAsignado(Organizador organizadorAsignado) {
        this.organizadorAsignado = organizadorAsignado;
        if (organizadorAsignado != null) {
            organizadorAsignado.asignarEvento();
        }
    }
}