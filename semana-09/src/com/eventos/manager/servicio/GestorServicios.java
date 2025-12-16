package com.eventos.manager.servicio;

import com.eventos.manager.modelo.ServicioBase;
import com.eventos.manager.excepciones.ServicioNoEncontradoException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que gestiona la colección de Servicios.
 * Aplica Serialización para persistencia (Semana 09) y Colecciones (Semana 08).
 */
public class GestorServicios {

    private static final String RUTA_DATOS = "data/servicios.dat";

    // Colección para Búsqueda Rápida O(1)
    private Map<String, ServicioBase> serviciosPorCodigo = new HashMap<>();
    // Colección para Iteración, Orden y Filtrado
    private List<ServicioBase> historialServicios = new ArrayList<>();

    public GestorServicios() {
        // Llama a cargarDatos() al instanciar el gestor
        cargarDatos();
    }

    // --- Métodos de Persistencia (I/O y Serialización) ---

    /** Guarda el estado del Gestor en un archivo binario. */
    public void guardarDatos() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(RUTA_DATOS))) {

            oos.writeObject(serviciosPorCodigo);
            System.out.println("✅ [PERSISTENCIA] Datos guardados con éxito en " + RUTA_DATOS);

        } catch (IOException e) {
            System.err.println("❌ [PERSISTENCIA] Error al guardar datos: " + e.getMessage());
        }
    }

    /** Carga los datos guardados del archivo binario. */
    public void cargarDatos() {
        File archivo = new File(RUTA_DATOS);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("💡 [PERSISTENCIA] Archivo de datos no encontrado o vacío. Iniciando vacío.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(RUTA_DATOS))) {

            // Deserialización: Carga el HashMap
            this.serviciosPorCodigo = (Map<String, ServicioBase>) ois.readObject();

            // Reconstruir el ArrayList a partir de los valores del HashMap (Sincronización)
            this.historialServicios = new ArrayList<>(serviciosPorCodigo.values());

            System.out.println("✅ [PERSISTENCIA] " + serviciosPorCodigo.size() + " servicios cargados.");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ [PERSISTENCIA] Error al cargar datos: " + e.getMessage());
        }
    }

    // --- CRUD con Colecciones ---

    public void agregarServicio(ServicioBase servicio) throws IllegalArgumentException {
        String codigo = servicio.getCodigo();

        // Validación de duplicados
        if (serviciosPorCodigo.containsKey(codigo)) {
            throw new IllegalArgumentException("Ya existe un servicio con código: " + codigo);
        }

        // Sincronización: Añadir a ambas colecciones
        serviciosPorCodigo.put(codigo, servicio);
        historialServicios.add(servicio);
        System.out.println("  [GESTIÓN] Servicio agregado: " + servicio.getNombre() + " (" + codigo + ")");
    }

    /** Búsqueda O(1) utilizando HashMap. */
    public ServicioBase buscarPorCodigo(String codigo) throws ServicioNoEncontradoException {
        ServicioBase servicio = serviciosPorCodigo.get(codigo);

        if (servicio == null) {
            throw new ServicioNoEncontradoException(codigo);
        }
        return servicio;
    }

    public void eliminarServicio(String codigo) throws ServicioNoEncontradoException {
        // Sincronización: Eliminar de ambas colecciones
        ServicioBase servicioEliminado = serviciosPorCodigo.remove(codigo);

        if (servicioEliminado == null) {
            throw new ServicioNoEncontradoException(codigo);
        }
        historialServicios.remove(servicioEliminado);
        System.out.println("  [GESTIÓN] Servicio eliminado: " + servicioEliminado.getNombre());
    }

    // --- Filtrado y Estadísticas (Streams) ---

    public List<ServicioBase> filtrarPorRangoPrecio(double min, double max) {
        // Filtrado usando Streams
        return historialServicios.stream()
                .filter(s -> s.calcularCostoTotal() >= min && s.calcularCostoTotal() <= max)
                .collect(Collectors.toList());
    }

    public double calcularCostoPromedio() {
        if (historialServicios.isEmpty()) return 0.0;

        // Estadísticas usando Streams
        return historialServicios.stream()
                .mapToDouble(ServicioBase::calcularCostoTotal)
                .summaryStatistics().getAverage();
    }

    public ServicioBase getServicioMasCaro() {
        // Encontrar el máximo usando Comparator
        return historialServicios.stream()
                .max(Comparator.comparingDouble(ServicioBase::calcularCostoTotal))
                .orElse(null);
    }

    public List<ServicioBase> getHistorialServicios() {
        return historialServicios;
    }
}