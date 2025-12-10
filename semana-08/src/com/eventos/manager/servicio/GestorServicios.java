package com.eventos.manager.servicio;

import com.eventos.manager.modelo.ServicioBase;
import com.eventos.manager.excepciones.ServicioNoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.DoubleSummaryStatistics;
import java.util.Comparator;

/**
 * Clase que gestiona la colección de Servicios utilizando HashMap para eficiencia
 * y ArrayList para filtrado.
 * Aplica Generics para seguridad de tipos (Map<String, ServicioBase>).
 */
public class GestorServicios {

    // 1. HashMap para búsqueda O(1) y control de unicidad.
    private Map<String, ServicioBase> serviciosPorCodigo = new HashMap<>();

    // 2. ArrayList para mantener el orden, iteración y permitir operaciones de Stream.
    private List<ServicioBase> historialServicios = new ArrayList<>();

    // --- CRUD con Colecciones y Generics ---

    /**
     * Agrega un servicio, validando que el código no exista previamente (HashMap).
     */
    public void agregarServicio(ServicioBase servicio) throws IllegalArgumentException {
        String codigo = servicio.getCodigo();

        // ❌ Error Común 2: Validación de duplicados
        if (serviciosPorCodigo.containsKey(codigo)) {
            throw new IllegalArgumentException("Ya existe un servicio con código: " + codigo + ". No se agregó.");
        }

        // ✅ CORRECTO: Sincronización de ambas estructuras
        serviciosPorCodigo.put(codigo, servicio);
        historialServicios.add(servicio);
        System.out.println("  [GESTIÓN] Servicio agregado: " + servicio.getNombre() + " (" + codigo + ")");
    }

    /**
     * Búsqueda O(1) utilizando HashMap.
     */
    public ServicioBase buscarPorCodigo(String codigo) throws ServicioNoEncontradoException {
        if (codigo == null || codigo.isEmpty() || !codigo.startsWith("S")) {
            // IllegalArgumentException (Unchecked) para errores de parámetro
            throw new IllegalArgumentException("El código de servicio es inválido o nulo.");
        }

        // Búsqueda eficiente O(1)
        ServicioBase servicio = serviciosPorCodigo.get(codigo);

        if (servicio == null) {
            // ServicioNoEncontradoException (Checked) para errores de negocio
            throw new ServicioNoEncontradoException(codigo);
        }
        return servicio;
    }

    /**
     * Elimina un servicio, sincronizando ambas colecciones.
     */
    public void eliminarServicio(String codigo) throws ServicioNoEncontradoException {

        // Remover de HashMap
        ServicioBase servicioEliminado = serviciosPorCodigo.remove(codigo);

        if (servicioEliminado == null) {
            throw new ServicioNoEncontradoException(codigo);
        }

        // ✅ CORRECTO: Eliminar del ArrayList para mantener sincronización
        historialServicios.remove(servicioEliminado);
        System.out.println("  [GESTIÓN] Servicio eliminado: " + servicioEliminado.getNombre());
    }

    // --- Filtrado (Uso de Streams) ---

    /**
     * Filtra los servicios por rango de costo total.
     */
    public List<ServicioBase> filtrarPorRangoPrecio(double min, double max) {
        if (min < 0 || max < min) {
            System.err.println("Advertencia: Rango de precios inválido.");
            return new ArrayList<>();
        }

        // Uso de Streams y Predicados para filtrado eficiente
        return historialServicios.stream()
                .filter(s -> s.calcularCostoTotal() >= min && s.calcularCostoTotal() <= max)
                .collect(Collectors.toList());
    }

    // --- Estadísticas (Uso de Streams) ---

    /**
     * Calcula el costo promedio de todos los servicios registrados.
     */
    public double calcularCostoPromedio() {
        if (historialServicios.isEmpty()) {
            return 0.0;
        }

        // Uso de DoubleSummaryStatistics para obtener promedio
        DoubleSummaryStatistics stats = historialServicios.stream()
                .mapToDouble(ServicioBase::calcularCostoTotal)
                .summaryStatistics();

        return stats.getAverage();
    }

    /**
     * Devuelve el servicio con el costo total más alto.
     */
    public ServicioBase getServicioMasCaro() {
        // Uso de Comparator para encontrar el máximo
        return historialServicios.stream()
                .max(Comparator.comparingDouble(ServicioBase::calcularCostoTotal))
                .orElse(null);
    }

    // Getter necesario para reportar el estado de la lista
    public List<ServicioBase> getHistorialServicios() {
        return historialServicios;
    }
}