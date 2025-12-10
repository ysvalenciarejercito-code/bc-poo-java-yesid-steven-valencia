package com.eventos.manager;

import com.eventos.manager.modelo.*;
import com.eventos.manager.servicio.GestorServicios;
import com.eventos.manager.excepciones.*;

import java.util.List;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SEMANA 08: Colecciones Avanzadas y Generics (Gestión de Eventos) ===\n");

        GestorServicios gestor = new GestorServicios();

        try {
            // --- 1. Agregar Servicios (Llenar colecciones) ---
            System.out.println("--- 1. Agregar Servicios Iniciales ---");
            // Se requiere manejo de CostoInvalidoException de Semana 07 (Checked)
            ServicioBase s1 = new ServicioInterno("Banquete Premium", 5000000.0, "Menú 5 tiempos", 20); // S001
            ServicioBase s2 = new ServicioInterno("Música DJ", 1200000.0, "Set de 4 horas", 1);          // S002
            ServicioBase s3 = new ServicioExterno("Decoración Floral", 800000.0, "Flores exóticas", 0.25); // S003
            ServicioBase s4 = new ServicioInterno("Coordinación", 3000000.0, "Logística completa", 1);  // S004

            gestor.agregarServicio(s1);
            gestor.agregarServicio(s2);
            gestor.agregarServicio(s3);
            gestor.agregarServicio(s4);

            // --- 2. Validación de Duplicados (Caso de error) ---
            System.out.println("\n--- 2. Validación de Duplicados (HashMap) ---");
            ServicioInterno sDuplicado = new ServicioInterno("Mobiliario", 1000.0, "Prueba", 1);
            sDuplicado.setCodigo("S001"); // Forzar el duplicado para la prueba
            gestor.agregarServicio(sDuplicado); // Esto lanza IllegalArgumentException

        } catch (CostoInvalidoException e) {
            System.err.println("❌ ERROR CHECKED (Costo Inválido): " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ ERROR DETECTADO (Duplicado): " + e.getMessage());
        }

        // --- 3. Búsqueda O(1) con HashMap (Éxito y Error) ---
        System.out.println("\n--- 3. Búsqueda Rápida (O(1)) ---");
        try {
            // Caso de éxito
            ServicioBase encontrado = gestor.buscarPorCodigo("S003");
            System.out.printf("✅ ENCONTRADO (S003): %s | Costo: $%,.2f\n",
                    encontrado.getNombre(), encontrado.calcularCostoTotal());

            // Caso de error (Lanza ServicioNoEncontradoException)
            gestor.buscarPorCodigo("S999");

        } catch (ServicioNoEncontradoException e) {
            System.err.println("❌ ERROR CHECKED: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ ERROR UNCHECKED (Parámetro): " + e.getMessage());
        }

        // --- 4. Filtrado Avanzado (Streams) ---
        System.out.println("\n--- 4. Filtrado: Servicios de Costo Medio ($1M - $3.5M) ---");
        List<ServicioBase> filtrados = gestor.filtrarPorRangoPrecio(1000000.0, 3500000.0);
        System.out.println("  Servicios encontrados (" + filtrados.size() + "):");
        filtrados.forEach(s ->
                System.out.printf("  - %s: $%,.2f\n", s.getNombre(), s.calcularCostoTotal()));

        // --- 5. Estadísticas (Streams) ---
        System.out.println("\n--- 5. Estadísticas de Costos ---");
        double promedio = gestor.calcularCostoPromedio();
        ServicioBase masCaro = gestor.getServicioMasCaro();

        System.out.printf("✅ Costo promedio de servicios: $%,.2f\n", promedio);
        if (masCaro != null) {
            System.out.printf("✅ Servicio más caro: %s ( $%,.2f)\n",
                    masCaro.getNombre(), masCaro.calcularCostoTotal());
        }

        // --- BONUS: Uso de finally (Mantenimiento de Semana 07) ---
        System.out.println("\n--- BONUS: Demostración de Bloque FINALLY ---");
        BufferedReader reader = null;
        try {
            System.out.println("  [RECURSO] Intentando abrir archivo de configuración...");
            reader = new BufferedReader(new FileReader("config.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.err.println("  ❌ ERROR: No se pudo leer el archivo (simulación de recurso externo).");
        } finally {
            // El FINALLY se ejecuta SIEMPRE para asegurar la limpieza
            System.out.println("  [RECURSO] Ejecutando FINALLY: Cerrando recurso...");
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("  [RECURSO] Recurso cerrado con éxito.");
                } catch (IOException e) {
                    System.err.println("  ❌ Error al cerrar el recurso.");
                }
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN SEMANA 08 ===");
    }
}