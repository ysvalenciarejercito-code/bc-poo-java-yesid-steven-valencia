public class Cliente {
    // Atributos (Mínimo 4)
    private String idCliente; // Identificador único del cliente.
    private String nombreCompleto; // Nombre de la persona o empresa.
    private String correo; // Email para comunicaciones.
    private String tipoCliente; // Social o Empresarial.
    private int eventosContratados; // Cantidad de eventos previos.

    // Constructor
    public Cliente(String idCliente, String nombreCompleto, String correo, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
        this.eventosContratados = 0; // Inicialmente 0.
    }

    // 1. Metodo para mostrar datos (void)
    public void mostrarDatos() {
        System.out.println("--- DATOS DEL CLIENTE ---");
        System.out.println("ID: " + this.idCliente);
        System.out.println("Nombre: " + this.nombreCompleto);
        System.out.println("Email: " + this.correo);
        System.out.println("Tipo: " + this.tipoCliente);
        System.out.println("Eventos previos: " + this.eventosContratados);
    }

    // 2. Metodo para simular contratación y retornar si es VIP (valor)
    /**
     * Simula la contratación de un evento e incrementa el contador.
     * @return true si es Cliente VIP (3 o más eventos), false de lo contrario.
     */
    public boolean contratarEvento() {
        this.eventosContratados++;
        System.out.println("-> Cliente " + this.nombreCompleto + " ha contratado un nuevo evento.");
        return this.eventosContratados >= 3;
    }

    // 3. Metodo para modificar correo (setter/funcional)
    public void actualizarCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
        System.out.println("-> Correo de " + this.nombreCompleto + " actualizado a: " + this.correo);
    }

    // Getter extra para el nombre
    public String getNombre() {
        return this.nombreCompleto;
    }
}