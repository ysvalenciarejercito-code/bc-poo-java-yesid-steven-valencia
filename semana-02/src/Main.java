public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE DOMINIO: CELEBRACIONES ESPECIALES (SEMANA 02) ===\n");

        // 1. CREACIÓN DE OBJETOS BASE

        // Clientes (Mínimo 2)
        Cliente clienteSocial = new Cliente("C-1001", "María Fernanda Torres", "maria.t@email.com", "Social");
        Cliente clienteEmpresarial = new Cliente("C-2005", "TecnoSoluciones S.A.S.", "contacto@tecnosol.com", "Empresarial");

        // Organizadores (Mínimo 2)
        Organizador orgLogistica = new Organizador("O-001", "Camilo Sánchez", "Coordinador Logístico");
        Organizador orgDiseno = new Organizador("O-002", "Laura Gómez", "Diseñadora de Ambientes");

        // Servicios (Mínimo 3)
        Servicio sMenu = new Servicio("Menú de Gala", "3 platos, buffet libre de postres.", 80000.0, true); // Requiere Proveedor Externo
        Servicio sDecoracion = new Servicio("Decoración Floral Élite", "Arreglos florales importados.", 2500000.0, true);
        Servicio sMobiliario = new Servicio("Alquiler de Sillas Tiffany", "150 unidades de sillas Tiffany blancas.", 15000.0, false); // Interno

        System.out.println("--- 1. Pruebas de Clases Base ---");
        sMenu.mostrarDetalle();
        orgLogistica.generarReporte(); // Muestra 0 eventos activos

        System.out.println("\n----------------------------------\n");

        // 2. CREACIÓN DE EVENTOS (Demostración de RELACIONES)
        // El constructor llama automáticamente a org.asignarEvento()
        Evento bodaLopez = new Evento("BOD-001", "Boda", 150, 8500000.0, "Hacienda El Paraiso", orgLogistica);
        Evento confCorp = new Evento("EMP-002", "Conferencia Corporativa", 80, 5200000.0, "Hotel Cosmos 100", orgDiseno);

        // Demostrar el uso del ArrayList dentro de Evento (Servicios)
        bodaLopez.agregarServicio(sMenu, 150);
        bodaLopez.agregarServicio(sDecoracion, 1);
        bodaLopez.agregarServicio(sMobiliario, 150);

        confCorp.agregarServicio(sMobiliario, 80);

        System.out.println("\n--- 2. Lógica de Evento y Relaciones ---");
        bodaLopez.mostrarInformacion();
        System.out.println("Costo total proyectado Boda: $" + bodaLopez.calcularCostoTotal()); // Método Calculado
        System.out.println("Servicios Externos a coordinar: " + bodaLopez.contarServiciosExternos()); // Método de negocio en Evento

        // Verificar que el Organizador actualizó su carga de trabajo (Lógica de constructor)
        orgLogistica.generarReporte(); // Muestra 1 evento activo

        System.out.println("\n----------------------------------\n");

        // 3. USO DE LA CLASE GESTORA (Demostración de ArrayList Central)
        GestorEventos sistemaCentral = new GestorEventos("Celebraciones Especiales");

        // Agregar Eventos a la colección central
        sistemaCentral.agregarEvento(bodaLopez);
        sistemaCentral.agregarEvento(confCorp);

        // Demostrar métodos de la clase Gestora
        sistemaCentral.mostrarTodosLosEventos(); // Itera la lista y llama a mostrarInformacion()

        System.out.println("\n--- 3. Lógica de Colección Central ---");
        int activosAntes = sistemaCentral.contarEventosActivos();
        System.out.println("Total de Eventos en Planificación (Activos): " + activosAntes); // Debe dar 2

        // Demostrar Setters y Recálculo
        bodaLopez.setActivo(false); // Llama a setter de Evento

        int activosDespues = sistemaCentral.contarEventosActivos();
        System.out.println("Total de Eventos en Planificación (después de finalizar Boda): " + activosDespues); // Debe dar 1

        System.out.println("\n=== DEMOSTRACIÓN COMPLETA DE POO FINALIZADA ===\n");
    }
}