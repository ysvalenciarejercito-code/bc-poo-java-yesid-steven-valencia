package implementaciones;

import interfaces.IContratable;
import interfaces.IReportable;

public class Evento implements IContratable, IReportable { // Implementa ambas interfaces

    private String nombreEvento;
    private double presupuestoBase;
    private boolean contratoActivo;

    public Evento(String nombreEvento, double presupuestoBase) {
        this.nombreEvento = nombreEvento;
        this.presupuestoBase = presupuestoBase;
        this.contratoActivo = false;
    }

    // --- Implementación de IContratable ---

    @Override // Uso de @Override
    public void iniciarContrato() {
        this.contratoActivo = true;
        System.out.println("  [CONTRATO] Contrato del evento '" + nombreEvento + "' iniciado.");
    }

    @Override // Uso de @Override
    public void finalizarContrato(boolean pagoCompletado) {
        this.contratoActivo = false;
        System.out.println("  [CONTRATO] Evento finalizado. Pago completo: " + pagoCompletado);
    }

    @Override // Uso de @Override
    public boolean estaContratado() {
        return this.contratoActivo;
    }

    // --- Implementación de IReportable ---

    @Override // Uso de @Override
    public String generarLineaReporte() {
        return "EVENTO PRINCIPAL: " + nombreEvento + " | Presupuesto Base: $" + presupuestoBase;
    }

    @Override // Uso de @Override
    public double obtenerValorReporte() {
        return presupuestoBase;
    }
}