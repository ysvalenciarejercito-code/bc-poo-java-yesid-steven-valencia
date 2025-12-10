public class Cliente {
    // ATRIBUTOS: Todos PRIVATE
    private String idCliente;
    private String nombreCompleto;
    private String correo;
    private String tipoCliente;
    private int eventosContratados;

    // --- CONSTRUCTORES SOBRECARGADOS ---

    // 1. Constructor PRINCIPAL: Completo (Usa los setters con validación)
    public Cliente(String idCliente, String nombreCompleto, String correo, String tipoCliente) {
        this.idCliente = idCliente;
        setNombreCompleto(nombreCompleto);
        setCorreo(correo); // Llama al setter con validación
        setTipoCliente(tipoCliente); // Llama al setter con validación
        this.eventosContratados = 0;
    }

    // 2. Constructor SECUNDARIO: (Tipo por defecto: Social)
    public Cliente(String idCliente, String nombreCompleto, String correo) {
        this(idCliente, nombreCompleto, correo, "Social");
    }

    // 3. Constructor MÍNIMO: (Correo y Tipo por defecto)
    public Cliente(String idCliente, String nombreCompleto) {
        this(idCliente, nombreCompleto, generarCorreoDefault(nombreCompleto), "Social");
    }

    // --- MÉTODOS DE NEGOCIO ---
    public void contratarEvento() {
        this.eventosContratados++;
        System.out.println("-> Cliente " + this.nombreCompleto + " ha contratado un nuevo evento.");
    }

    // MÉTODO PRIVADO AUXILIAR
    private static String generarCorreoDefault(String nombre) {
        return nombre.toLowerCase().replaceAll("\\s+", ".") + "@temp.celebraciones.com";
    }

    // --- GETTERS ---
    public String getIdCliente() { return idCliente; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCorreo() { return correo; }
    public String getTipoCliente() { return tipoCliente; }
    public int getEventosContratados() { return eventosContratados; }

    // --- SETTERS CON VALIDACIÓN ---

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser vacío.");
        }
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreo(String correo) {
        // Validación de formato básico de email
        if (correo == null || !correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }
        this.correo = correo;
    }

    public void setTipoCliente(String tipoCliente) {
        String tipoUpper = tipoCliente.toUpperCase();
        if (!tipoUpper.equals("SOCIAL") && !tipoUpper.equals("EMPRESARIAL")) {
            throw new IllegalArgumentException("Tipo de cliente inválido. Use 'Social' o 'Empresarial'.");
        }
        this.tipoCliente = tipoCliente;
    }
}