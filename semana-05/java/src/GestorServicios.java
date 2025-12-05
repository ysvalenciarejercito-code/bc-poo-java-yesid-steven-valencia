
public class GestorServicios {
    private ArrayList<ServicioBase> listaServicios;

    public GestorServicios() {
        this.listaServicios = new ArrayList<>();
    }

    public void agregarServicio(ServicioBase servicio) {
        this.listaServicios.add(servicio);
    }

    // --- Sobrecarga de Métodos (Ejercicio 1) ---

    // 1. Sobrecarga: Buscar servicio por nombre (String)
    public ServicioBase buscarServicio(String nombre) {
        for (ServicioBase s : listaServicios) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }

    // 2. Sobrecarga: Buscar servicios por costo base mínimo (double)
    public ArrayList<ServicioBase> buscarServicio(double costoMinimo) {
        ArrayList<ServicioBase> resultado = new ArrayList<>();
        for (ServicioBase s : listaServicios) {
            if (s.getCostoBase() >= costoMinimo) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // 3. Sobrecarga: Buscar servicios por tipo de clase (Class<?>)
    public ArrayList<ServicioBase> buscarServicio(Class<?> tipoClase) {
        ArrayList<ServicioBase> resultado = new ArrayList<>();
        for (ServicioBase s : listaServicios) {
            if (tipoClase.isInstance(s)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // --- Métodos Polimórficos ---

    // Método Polimórfico: Calcula el costo total de la colección
    public double calcularCostoTotalGlobal() {
        double total = 0.0;
        for (ServicioBase servicio : listaServicios) {
            // Dynamic Binding: Llama al calcularCostoTotal() específico de la subclase
            total += servicio.calcularCostoTotal();
        }
        return total;
    }

    // Getter para la demostración en Main
    public ArrayList<ServicioBase> getListaServicios() {
        return listaServicios;
    }
}