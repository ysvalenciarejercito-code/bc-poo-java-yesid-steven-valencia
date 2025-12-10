

package com.eventos.manager;

import com.eventos.manager.modelo.*;
import com.eventos.manager.servicios.GestorServicios;
import com.eventos.manager.excepciones.CostoInvalidoException;
import com.eventos.manager.excepciones.ServicioNoEncontradoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SEMANA 07: Robustez y Excepciones en Gestión de Eventos ===\n");

        GestorServicios gestor = new GestorServicios();

        // --- CASO 1: OPERACIÓN EXITOSA (Costo válido) ✅
        System.out.println("--- Caso 1: Servicio Agregado Exitosamente ---");
        try {
            // Crea e intenta agregar un servicio válido
            ServicioInterno s1 = new ServicioInterno("Fotografía", 3500000.0, "Cobertura total del evento", 1);
            gestor.agregarServicio(s1);
        } catch (CostoInvalidoException e) {
            // No debería entrar aquí
            System.err.println("❌ ERROR INESPERADO: " + e.getMessage());
        }

        // --- CASO 2: EXCEPCIÓN PERSONALIZADA CHECKED (CostoInvalidoException) ❌
        System.out.println("\n--- Caso 2: Error de Validación de Costo (Checked) ---");
        try {
            // Esto fallará en el constructor y lanza CostoInvalidoException
            ServicioInterno sFallido = new ServicioInterno("Mobiliario", 0.0, "Sillas y mesas", 100);
            gestor.agregarServicio(sFallido);
        } catch (CostoInvalidoException e) {
            // Bloque CATCH para manejo elegante del error de negocio
            System.err.println("❌ ERROR DETECTADO (CostoInválido): " + e.getMessage());
            System.out.println("  [INFO] El servicio no pudo ser registrado en el sistema.");
        }

        // --- CASO 3: EXCEPCIÓN CHECKED (ServicioNoEncontradoException) ❌
        System.out.println("\n--- Caso 3: Error de Búsqueda de Servicio (Checked) ---");
        try {
            String codigoBuscado = "S999";
            // El compilador OBLIGA a usar try-catch aquí (ServicioNoEncontradoException es Checked)
            ServicioBase sEncontrado = gestor.buscarPorCodigo(codigoBuscado);
            System.out.println("✅ Servicio encontrado: " + sEncontrado.getNombre());
        } catch (ServicioNoEncontradoException e) {
            System.err.println("❌ ERROR DE BÚSQUEDA: " + e.getMessage());
        }

        // --- CASO 4: EXCEPCIÓN UNCHECKED (IllegalArgumentException) ❌
        System.out.println("\n--- Caso 4: Excepción Unchecked (Error de Lógica/Parámetro) ---");
        try {
            String codigoInvalido = null;
            // Lanza IllegalArgumentException (Unchecked) desde el Gestor
            gestor.buscarPorCodigo(codigoInvalido);
        } catch (IllegalArgumentException e) {
            System.err.println("❌ ERROR UNCHECKED: " + e.getMessage());
        } catch (ServicioNoEncontradoException e) {
            // Necesario solo porque el método lo declara, aunque no se lanza aquí
            System.err.println("❌ ERROR CHECKED INESPERADO: " + e.getMessage());
        }

        // --- CASO 5: USO DE FINALLY PARA LIMPIEZA ✅
        System.out.println("\n--- Caso 5: Demostración de Bloque FINALLY ---");
        // Simulación de uso de un recurso externo (archivo)
        BufferedReader reader = null;
        try {
            System.out.println("  [RECURSO] Abriendo recurso...");
            reader = new BufferedReader(new FileReader("config.txt")); // Esto causará un IOException si el archivo no existe
            String linea = reader.readLine();
            System.out.println("  [RECURSO] Lectura exitosa: " + linea);
        } catch (IOException e) {
            System.err.println("  ❌ ERROR: No se pudo leer el archivo de configuración (IOException).");
        } finally {
            // El FINALLY se ejecuta SIEMPRE para asegurar que el recurso se cierre
            System.out.println("  [RECURSO] Ejecutando FINALLY: Cerrando recurso...");
            if (reader != null) {
                try {
                    reader.close(); // Se debe envolver el close() en un try-catch
                    System.out.println("  [RECURSO] Recurso cerrado con éxito.");
                } catch (IOException e) {
                    System.err.println("  ❌ Error al cerrar el recurso: " + e.getMessage());
                }
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}