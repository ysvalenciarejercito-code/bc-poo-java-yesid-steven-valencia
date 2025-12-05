import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SEMANA 05: POLIMORFISMO COMPLETO ===\n");

        GestorServicios gestor = new GestorServicios();

        // 1. Crear objetos (Polimorfismo en la creación)
        ServicioInterno s1 = new ServicioInterno(
                "Mobiliario Básico", 1500000.0,
                "Alquiler de mesas y sillas estándar de la empresa", 300
        );
        ServicioExterno s2 = new ServicioExterno(
                "Catering Gourmet", 8000000.0,
                "Menú de 3 tiempos con chef externo", "Chef Gourmet S.A."
        );
        ServicioInterno s3 = new ServicioInterno(
                "Staff de Recepción", 500000.0,
                "Personal de bienvenida y guía", 10
        );

        // Agregar al gestor (Método polimórfico - Ejercicio 3)
        gestor.agregarServicio(s1);
        gestor.agregarServicio(s2);
        gestor.agregarServicio(s3);

        System.out.println("--- 1. Polimorfismo Dinámico y Sobrescritura (Ejercicio 4) ---");

        // Bucle que recorre la colección polimórfica (ArrayList de ServicioBase)
        for (ServicioBase servicio : gestor.getListaServicios()) {

            // Dynamic Binding en obtenerDetalle()
            System.out.println(servicio.obtenerDetalle());

            // Dynamic Binding en calcularCostoTotal()
            double costoFinal = servicio.calcularCostoTotal();

            System.out.printf("  -> Costo Final Calculado: $%.2f%n", costoFinal);
            System.out.println("  -> Tipo real: " + servicio.getClass().getSimpleName());
            System.out.println("---");
        }

        System.out.printf("\nCosto Total de Evento (Polimórfico): $%.2f%n", gestor.calcularCostoTotalGlobal());

        // 2. Demostración de Sobrecarga (Ejercicio 1)
        System.out.println("\n--- 2. Demostración de Sobrecarga de Métodos ---");

        // Sobrecarga 1: Buscar por nombre (String)
        ServicioBase encontrado = gestor.buscarServicio("Catering Gourmet");
        System.out.println("A. Búsqueda por Nombre: " + (encontrado != null ? encontrado.getNombre() : "No encontrado"));

        // Sobrecarga 2: Buscar por costo mínimo (double)
        ArrayList<ServicioBase> caros = gestor.buscarServicio(2000000.0);
        System.out.println("B. Búsqueda por Costo Mínimo: " + caros.size() + " servicios caros encontrados.");

        // Sobrecarga 3: Buscar por tipo de clase (Class<?>)
        ArrayList<ServicioBase> internos = gestor.buscarServicio(ServicioInterno.class);
        System.out.println("C. Búsqueda por Tipo (Interno): " + internos.size() + " servicios encontrados.");

        System.out.println("\n=== ENTREGA SEMANA 05 COMPLETADA ===");
    }
}