public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN SEMANA 04: HERENCIA Y POLIMORFISMO ===\n");

        // 1. Array Polimórfico: Creamos un array de la clase Padre (ServicioBase)
        // Podemos guardar cualquier objeto que herede de ServicioBase.
        ServicioBase[] listaServicios = new ServicioBase[3];

        // 2. Almacenamos objetos de las clases Hijas en el array del Padre

        // Objeto 1: Servicio Interno (Cálculo con margen del 10%)
        listaServicios[0] = new ServicioInterno(
                "Mobiliario Básico", 1500000.0,
                "Alquiler de mesas y sillas estándar", 300
        );

        // Objeto 2: Servicio Externo (Cálculo con recargo del 5%)
        listaServicios[1] = new ServicioExterno(
                "Catering Gourmet", 8000000.0,
                "Menú de 3 tiempos con chef externo", "Chef Gourmet S.A."
        );

        // Objeto 3: Otro Servicio Interno
        listaServicios[2] = new ServicioInterno(
                "Staff de Recepción", 500000.0,
                "Personal de bienvenida y guía", 10
        );

        System.out.println("--- 3. Polimorfismo en Acción (Iteración) ---");
        double costoTotalGeneral = 0.0;

        // Iteramos el array de tipo Padre (ServicioBase)
        for (ServicioBase servicio : listaServicios) {

            // Llama al método del Padre (ServicioBase). Java determina en tiempo de ejecución
            // cuál es la versión correcta (Interno o Externo) del método sobrescrito.
            servicio.mostrarInfoBase();

            // Polimorfismo: Llama a la implementación específica de calcularCostoTotal()
            double costoFinal = servicio.calcularCostoTotal();

            System.out.printf("Costo Final Aplicando Lógica de Clase: $%.2f%n", costoFinal);
            System.out.println("---");

            costoTotalGeneral += costoFinal;
        }

        System.out.println("Costo Total de Servicios Contratados: $" + costoTotalGeneral);
    }
}