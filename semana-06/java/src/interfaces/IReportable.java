package interfaces;

/**
 * Interface 2: Define la capacidad de una entidad para generar datos para un informe final.
 */
public interface IReportable {

    String generarLineaReporte();

    double obtenerValorReporte();
}