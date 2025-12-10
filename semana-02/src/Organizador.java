public class Organizador {
    // Atributos (Mínimo 3)
    private String idOrganizador; // Identificador único de empleado
    private String nombre;
    private String cargo; // Rol específico (ej: Coordinador de Logística)
    private int eventosActivos; // Número de eventos que tiene asignados actualmente

    // Constructor completo
    public Organizador(String idOrganizador, String nombre, String cargo) {
        this.idOrganizador = idOrganizador;
        this.nombre = nombre;
        this.cargo = cargo;
        this.eventosActivos = 0; // Inicialmente no tiene eventos asignados
    }

    // Método de negocio: Simula la asignación de un evento
    public void asignarEvento() {
        this.eventosActivos++;
        System.out.println("-> El organizador " + this.nombre + " ha sido asignado a un nuevo evento.");
    }

    // Método de negocio: Genera un reporte (impresión)
    public void generarReporte() {
        System.out.println("Reporte Semanal: " + this.nombre + " (" + this.cargo + ") tiene " + this.eventosActivos + " eventos activos.");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEventosActivos() {
        return eventosActivos;
    }

    // Setters
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
