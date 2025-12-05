# Jerarquía de Clases - Semana 04: Servicios de Eventos

## Diagrama

Este diagrama visualiza la relación de **Herencia** (`is-a` o "es un tipo de") entre las clases:

```mermaid
classDiagram
    abstract ServicioBase {
        # String nombre
        # double costoBase
        + mostrarInfoBase()
        + abstract calcularCostoTotal()
    }
    
    ServicioInterno --|> ServicioBase
    ServicioExterno --|> ServicioBase
    
    ServicioInterno {
        - int stockPropio
        + calcularCostoTotal()
    }
    
    ServicioExterno {
        - String proveedor
        + calcularCostoTotal()
        + mostrarInfoBase()
    }