public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA SEMANA 03: SOBRECARGA Y VALIDACIÓN ===\n");

        // NOTA: Para este Main, todos los datos usados son válidos para demostrar
        // la funcionalidad sin lanzar errores.

        // --- DEMOSTRACIÓN DE SOBRECARGA DE CONSTRUCTORES ---

        System.out.println("--- 1. Clientes (3 Constructores Diferentes) ---");

        // Cliente 1: Usa Constructor PRINCIPAL (Completo)
        Cliente c1 = new Cliente("C-001", "Roberto Ríos", "roberto@rios.com", "Empresarial");
        System.out.println("✅ C1 Completo: " + c1.getNombreCompleto() + " (" + c1.getTipoCliente() + ")");

        // Cliente 2: Usa Constructor SECUNDARIO (Tipo por defecto: Social)
        Cliente c2 = new Cliente("C-002", "Ana Pérez", "ana.perez@test.net");
        System.out.println("✅ C2 Básico: " + c2.getNombreCompleto() + " | Tipo: " + c2.getTipoCliente());

        // Cliente 3: Usa Constructor MÍNIMO (Genera correo por defecto)
        Cliente c3 = new Cliente("C-003", "Luis Gómez");
        System.out.println("✅ C3 Mínimo: " + c3.getNombreCompleto() + " | Correo: " + c3.getCorreo());

        // Organizador: Usa Constructor Secundario
        Organizador org1 = new Organizador("O-100", "Elena Diaz");

        System.out.println("\n--- 2. Eventos (3 Constructores Diferentes) ---");

        // Evento 1: Usa Constructor PRINCIPAL (Completo)
        Evento e1 = new Evento("BOD-005", "Boda", 120, 15000000.0, "Finca Los Robles", org1);
        System.out.println("✅ E1 Completo: " + e1.getCodigo() + " | Asistentes: " + e1.getAsistentes());

        // Evento 2: Usa Constructor de COTIZACIÓN RÁPIDA (Solo datos esenciales)
        Evento e2 = new Evento("COT-101", "Cumpleaños", 50);
        System.out.println("✅ E2 Rápido: " + e2.getCodigo() + " | Costo Inicial: " + e2.getCostoBase());

        // Evento 3: Usa Constructor MÍNIMO (Solo Tipo y Asistentes)
        Evento e3 = new Evento("Conferencia", 80);
        System.out.println("✅ E3 Mínimo: " + e3.getCodigo() + " | Asignado a: " + e3.getLugar());

        // --- 3. DEMOSTRACIÓN DE ENCAPSULACIÓN Y SETTERS VALIDADOS ---

        System.out.println("\n--- 3. Pruebas de Setters con Datos Válidos ---");

        // 3.1. Prueba de Setter de Evento (Asistentes)
        e1.setAsistentes(150); // El setter valida que sea > 0 y asigna
        System.out.println("-> E1 Asistentes actualizados a: " + e1.getAsistentes());

        // 3.2. Prueba de Setter de Evento (Costo Base)
        e2.setCostoBase(500000.0); // El setter valida que sea >= 0 y asigna
        System.out.println("-> E2 Costo actualizado a: $" + e2.getCostoBase());

        // 3.3. Prueba de Setter de Cliente (Correo)
        c2.setCorreo("ana.perez.nueva@corporativo.com");
        System.out.println("-> C2 Correo actualizado a: " + c2.getCorreo());


        // Nota: Si intentaras c1.setAsistentes(-10); el programa se detendría con el error.

        System.out.println("\n=== ENTREGA DE SEMANA 03 COMPLETADA ===");
    }
}