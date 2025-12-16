package com.eventos.manager;

import com.eventos.manager.modelo.*;
import com.eventos.manager.servicio.GestorServicios;
import com.eventos.manager.excepciones.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    // El gestor llama a cargarDatos() al instanciarse, habilitando la persistencia.
    private static GestorServicios gestor = new GestorServicios();

    public static void main(String[] args) {
        System.out.println("=== PROYECTO FINAL: GESTIÓN DE EVENTOS (POO y PERSISTENCIA) ===\n");

        // Inicializar datos si es la primera ejecución
        if (gestor.getHistorialServicios().isEmpty()) {
            System.out.println(">>> No hay datos guardados. Inicializando con datos de prueba.");
            inicializarDatos();
        }

        mostrarMenu();

        // Guardar datos al finalizar el programa
        System.out.println("\n[Saliendo] Guardando datos de la sesión...");
        gestor.guardarDatos();
        System.out.println("=== PROGRAMA FINALIZADO ===");
        scanner.close();
    }

    private static void inicializarDatos() {
        try {
            // Demostración de Herencia y Polimorfismo
            ServicioBase s1 = new ServicioInterno("Banquete Matrimonial", 5000000.0, "Menú 5 tiempos", 20);
            ServicioBase s2 = new ServicioExterno("Fotografía Profesional", 1500000.0, "Álbum digital", 0.10);

            gestor.agregarServicio(s1);
            gestor.agregarServicio(s2);

        } catch (CostoInvalidoException | IllegalArgumentException e) {
            System.err.println("Error de inicialización: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar nuevo servicio (Interno)");
            System.out.println("2. Buscar servicio por código (Búsqueda O(1))");
            System.out.println("3. Listar todos los servicios");
            System.out.println("4. Eliminar servicio");
            System.out.println("5. Mostrar Estadísticas (Promedio/Más Caro)");
            System.out.println("6. Filtrar por rango de precio");
            System.out.println("0. Salir y Guardar Datos");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarNuevoServicio();
                        break;
                    case 2:
                        buscarServicio();
                        break;
                    case 3:
                        listarServicios();
                        break;
                    case 4:
                        eliminarServicio();
                        break;
                    case 5:
                        mostrarEstadisticas();
                        break;
                    case 6:
                        filtrarServicios();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                // Manejo de excepción Unchecked por entrada incorrecta
                System.err.println("❌ ERROR: Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
                opcion = -1;
            } catch (CostoInvalidoException | ServicioNoEncontradoException | IllegalArgumentException e) {
                // Manejo de excepciones de negocio (Checked y Unchecked)
                System.err.println("❌ ERROR DE NEGOCIO: " + e.getMessage());
                opcion = -1;
            } catch (Exception e) {
                System.err.println("❌ ERROR INESPERADO: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 0);
    }

    // Métodos para el menú

    private static void agregarNuevoServicio() throws CostoInvalidoException {
        System.out.print("Nombre del servicio: "); String nombre = scanner.nextLine();
        System.out.print("Costo Base: "); double costo = scanner.nextDouble();
        scanner.nextLine();

        // Simulación: siempre agrega un ServicioInterno
        gestor.agregarServicio(new ServicioInterno(nombre, costo, "Agregado por menú", 1));
    }

    private static void buscarServicio() throws ServicioNoEncontradoException {
        System.out.print("Ingrese código (ej. S001): "); String codigo = scanner.nextLine();
        ServicioBase s = gestor.buscarPorCodigo(codigo);
        System.out.printf(">> ENCONTRADO: %s | Costo Total: $%,.2f\n", s.getNombre(), s.calcularCostoTotal());
        System.out.println("   Detalle: " + s.obtenerDetalleContrato());
    }

    private static void listarServicios() {
        System.out.println("\n--- LISTA DE SERVICIOS (" + gestor.getHistorialServicios().size() + " en total) ---");
        gestor.getHistorialServicios().forEach(servicio ->
                System.out.printf("[%s] %s | Costo Total: $%,.2f | Tipo: %s\n",
                        servicio.getCodigo(), servicio.getNombre(), servicio.calcularCostoTotal(),
                        servicio.getClass().getSimpleName())); // Polimorfismo: getClass().getSimpleName()
    }

    private static void eliminarServicio() throws ServicioNoEncontradoException {
        System.out.print("Código a eliminar: "); String codElim = scanner.nextLine();
        gestor.eliminarServicio(codElim);
    }

    private static void mostrarEstadisticas() {
        System.out.printf("\n[ESTADÍSTICAS]\n");
        System.out.printf("Total de servicios registrados: %d\n", gestor.getHistorialServicios().size());
        System.out.printf("Promedio de Costos: $%,.2f\n", gestor.calcularCostoPromedio());
        ServicioBase caro = gestor.getServicioMasCaro();
        if (caro != null) System.out.printf("Servicio Más Caro: %s ($%,.2f)\n", caro.getNombre(), caro.calcularCostoTotal());
    }

    private static void filtrarServicios() {
        System.out.print("Costo Mínimo: "); double min = scanner.nextDouble();
        System.out.print("Costo Máximo: "); double max = scanner.nextDouble();
        scanner.nextLine();
        List<ServicioBase> filtrados = gestor.filtrarPorRangoPrecio(min, max);
        System.out.println("\n--- RESULTADO DEL FILTRO (" + filtrados.size() + ") ---");
        filtrados.forEach(s_f -> System.out.printf("[%s] %s ($%,.2f)\n", s_f.getCodigo(), s_f.getNombre(), s_f.calcularCostoTotal()));
    }
}