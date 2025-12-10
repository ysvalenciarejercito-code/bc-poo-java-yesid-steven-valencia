import abstractas.ServicioBase;
import implementaciones.*;
import interfaces.IContratable;
import interfaces.IReportable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SEMANA 06: ABSTRACCIÓN E INTERFACES EN GESTIÓN DE EVENTOS ===\n");

        // 1. Polimorfismo con Clase Abstracta (Ejercicio 3 - Requisito 1)
        System.out.println("--- 1. Polimorfismo de Servicios (Abstracta) ---");

        // Array/List de tipo abstracto
        ArrayList<ServicioBase> serviciosContratados = new ArrayList<>();

        serviciosContratados.add(new ServicioInterno(
                "Mobiliario Fiesta", 800000.0, "Sillas y mesas propias", 100));

        serviciosContratados.add(new ServicioExterno(
                "Catering Bodas", 12000000.0, "Menú de 5 tiempos", "Gourmet Chef S.A."));

        serviciosContratados.add(new ServicioInterno(
                "Personal Staff", 400000.0, "Staff de apoyo en sitio", 15));

        double costoTotal = 0.0;

        // Bucle recorriendo objetos polimórficos
        for (ServicioBase servicio : serviciosContratados) {
            servicio.mostrarInformacionBase(); // Método concreto
            System.out.println("Detalle: " + servicio.obtenerDetalleCompleto()); // Método abstracto

            double costo = servicio.calcularCostoTotal(); // Polimorfismo (Dynamic Binding)
            System.out.printf("  Costo Final Aplicado: $%.2f%n", costo);
            System.out.println("---");
            costoTotal += costo;
        }
        System.out.printf("COSTO TOTAL EN SERVICIOS: $%.2f%n", costoTotal);

        // 2. Demostrar Interfaces (Ejercicio 3 - Requisito 2)
        System.out.println("\n--- 2. Demostración de Capacidades con Interfaces ---");

        Evento eventoPrincipal = new Evento("Quince Años de Sofía", 15000000.0);

        // Usar referencia de tipo interface IContratable
        IContratable contrato = eventoPrincipal;

        System.out.println("Estado Contrato: " + contrato.estaContratado());
        contrato.iniciarContrato();

        // Demostrar Múltiple Implementación (Usar el mismo objeto como IReportable)
        IReportable reporte = eventoPrincipal;

        System.out.println("\nGenerando Línea de Reporte (IReportable):");
        System.out.println(reporte.generarLineaReporte());
        System.out.printf("Valor Reportado: $%.2f%n", reporte.obtenerValorReporte());

        contrato.finalizarContrato(true);
        System.out.println("Estado Contrato Final: " + contrato.estaContratado());

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}