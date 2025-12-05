//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE DOMINIO: CELEBRACIONES ESPECIALES ===\n");

        // 1. Crear mínimo 2 objetos de cada clase
        // Evento 1: Boda
        Evento bodaLopez = new Evento("BOD-001", "Boda", 150, 8500000.0, "Hacienda El Paraiso");
        // Evento 2: Empresarial
        Evento confCorp = new Evento("EMP-002", "Conferencia Corporativa", 80, 5200000.0, "Hotel Cosmos 100");

        // Cliente 1: Social
        Cliente clieSocial = new Cliente("C-1001", "María Fernanda Torres", "maria.t@email.com", "Social");
        // Cliente 2: Empresarial
        Cliente clieCorp = new Cliente("C-2005", "TecnoSoluciones S.A.S.", "contacto@tecnosol.com", "Empresarial");


        System.out.println("--- DEMOSTRACIÓN CLASE CLIENTE ---");
        // Llamar a todos los métodos de Cliente
        clieSocial.mostrarDatos(); // Muestra info

        clieCorp.actualizarCorreo("gerencia@tecnosol.com"); // Llama a método 3 (setter)
        boolean esVip = clieCorp.contratarEvento(); // Llama a método 2 (valor calculado)
        System.out.println("¿TecnoSoluciones es Cliente VIP?: " + esVip);

        System.out.println("\n----------------------------------\n");


        System.out.println("--- DEMOSTRACIÓN CLASE EVENTO ---");
        // Llamar a todos los métodos de Evento
        bodaLopez.mostrarInformacion(); // Llama a metodo 1 (void)
        bodaLopez.planificar("Definir menú de 3 tiempos y confirmar proveedor de fotografía."); // Llama a metodo void extra
        double costoBoda = bodaLopez.calcularCostoTotal(); // Llama a metodo 2 (calculado)
        System.out.printf("Costo Total Proyectado de la Boda: $%.2f%n", costoBoda);

        System.out.println("\n--- MANIPULACIÓN DE EVENTO EMPRESARIAL ---");
        System.out.println("Código del Evento (Getter): " + confCorp.getCodigo()); // Llama a metodo 3 (getter)
        confCorp.setActivo(false); // Llama a metodo 4 (setter)
        confCorp.mostrarInformacion(); // Vuelve a imprimir para verificar el cambio

        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println("Nombre del Cliente Social: " + clieSocial.getNombre());
    }
}