package interfaces;

/**
 * Interface 1: Define el comportamiento de gestión de contratos.
 */
public interface IContratable {

    void iniciarContrato();

    void finalizarContrato(boolean pagoCompletado);

    boolean estaContratado();
}