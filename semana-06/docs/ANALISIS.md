# Análisis de Diseño - Semana 06: Gestión de Eventos

## 1. Identificación de Abstracciones

### Clase Abstracta: ServicioBase

**Nombre:** `abstract class ServicioBase`

**¿Por qué es abstracta?**
Elegí hacer `ServicioBase` abstracta porque:
1. **Relación "es-un" clara:** Todos los servicios contratados son un tipo de `ServicioBase`.
2. **Necesidad de Estado:** Requería atributos comunes (`nombre`, `costoBase`) definidos como `protected` para ser heredados y accedidos directamente por las subclases.
3. **Comportamiento Común:** Define el método concreto `mostrarInformacionBase()`, que es idéntico en todas las subclases y evita la duplicación de código.
4. **Contrato de Comportamiento:** Define los métodos abstractos `calcularCostoTotal()` y `obtenerDetalleCompleto()`, forzando a cada subclase a implementar su lógica específica de costos y descripción.

**Jerarquía:**