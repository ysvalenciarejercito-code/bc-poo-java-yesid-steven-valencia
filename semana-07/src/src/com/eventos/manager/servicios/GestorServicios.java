package com.eventos.manager.servicios;

import com.eventos.manager.modelo.ServicioBase;
import com.eventos.manager.excepciones.ServicioNoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    private List<ServicioBase> listaServicios = new ArrayList<>();

    public void agregarServicio(ServicioBase servicio) {
        listaServicios.add(servicio);
        System.out.println("  [GESTIÓN] Servicio agregado: " + servicio.getNombre());
    }

    // APLICACIÓN DE EXCEPCIONES CHECKED EN EL MÉTODO (Ejercicio 2)
    public ServicioBase buscarPorCodigo(String codigo) throws ServicioNoEncontradoException {

        // Validación de formato (IllegalArgumentException es Unchecked, no necesita throws)
        if (codigo == null || codigo.isEmpty() || !codigo.startsWith("S")) {
            throw new IllegalArgumentException("El código de servicio es inválido o nulo.");
        }

        for (ServicioBase s : listaServicios) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        // Se lanza la excepción personalizada Checked si el bucle termina sin éxito
        throw new ServicioNoEncontradoException(codigo);
    }

    public List<ServicioBase> getListaServicios() {
        return listaServicios;
    }
}