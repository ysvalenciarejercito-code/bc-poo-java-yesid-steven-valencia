public class Organizador {
    private String idOrganizador;
    private String nombre;
    private String cargo;
    private int eventosActivos;

    // Constructor PRINCIPAL
    public Organizador(String idOrganizador, String nombre, String cargo) {
        setIdOrganizador(idOrganizador);
        setNombre(nombre);
        setCargo(cargo);
        this.eventosActivos = 0;
    }

    // Constructor SECUNDARIO (Cargo por defecto: "Organizador General")
    public Organizador(String idOrganizador, String nombre) {
        this(idOrganizador, nombre, "Organizador General");
    }

    // Método de negocio
    public void asignarEvento() {
        this.eventosActivos++;
        System.out.println("-> El organizador " + this.nombre + " ha sido asignado a un nuevo evento.");
    }

    // Método de negocio
    public void generarReporte() {
        System.out.println("Reporte Semanal: " + this.nombre + " (" + this.cargo + ") tiene " + this.eventosActivos + " eventos activos.");
    }

    // --- GETTERS ---
    public String getIdOrganizador() { return idOrganizador; }
    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }
    public int getEventosActivos() { return eventosActivos; }

    // --- SETTERS con VALIDACIÓN ---
    private void setIdOrganizador(String idOrganizador) {
        if (idOrganizador == null || idOrganizador.trim().isEmpty()) {
            throw new IllegalArgumentException("ID de organizador no puede ser vacío.");
        }
        this.idOrganizador = idOrganizador;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío.");
        }
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Cargo no puede ser vacío.");
        }
        this.cargo = cargo;
    }
}