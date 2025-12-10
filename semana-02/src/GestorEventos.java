// Archivo GestorEventos.java (Final y funcional)
import java.util.ArrayList;

public class GestorEventos {

    private String nombreEmpresa;
    private ArrayList<Evento> listaEventos;

    // Constructor
    public GestorEventos(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.listaEventos = new ArrayList<>();
        System.out.println("-> Sistema Gestor de Eventos para: " + this.nombreEmpresa + " iniciado.");
    }

    // Método para agregar un Evento a la lista
    public void agregarEvento(Evento evento) {
        this.listaEventos.add(evento);
        System.out.println("-> Evento " + evento.getCodigo() + " agregado al sistema central.");
    }

    // Método para mostrar todos los Eventos registrados
    public void mostrarTodosLosEventos() {
        System.out.println("\n*** EVENTOS REGISTRADOS EN " + this.nombreEmpresa.toUpperCase() + " ***");
        if (listaEventos.isEmpty()) {
            System.out.println("No hay eventos registrados en el sistema.");
            return;
        }

        for (Evento evento : listaEventos) {
            evento.mostrarInformacion(); // Usa el método corregido
            System.out.println("---");
        }
    }

    // Método de Negocio: Cuenta los Eventos Activos
    public int contarEventosActivos() {
        int activos = 0;
        for (Evento evento : listaEventos) {
            // Usa el getter isActivo() de la clase Evento
            if (evento.isActivo()) {
                activos++;
            }
        }
        return activos;
    }
}