

Análisis de Polimorfismo - Semana 05

1. Sobrecarga (Overloading)

La Sobrecarga se implementó en la clase **`GestorServicios.java`** para ofrecer múltiples formas de búsqueda de servicios.

| Método | Parámetros | Justificación en el Dominio |
| :--- | :--- | :--- |
| `buscarServicio` | `String nombre` | Búsqueda directa y rápida por el nombre exacto del servicio. |
| `buscarServicio` | `double costoMinimo` | Permite filtrar servicios que superen un umbral de inversión presupuestaria. |
| `buscarServicio` | `Class<?> tipoClase` | Permite filtrar por naturaleza del servicio (`Interno` o `Externo`). |

2. Sobrescritura (Overriding)

Se utilizó **`@Override`** en dos métodos de la clase padre `ServicioBase` para especializar el comportamiento en las subclases.

| Método | Clase Padre (`ServicioBase`) | Subclase 1 (`ServicioInterno`) | Subclase 2 (`ServicioExterno`) |
| :--- | :--- | :--- | :--- |
| `calcularCostoTotal()` | Abstracto (Costo base) | Aplica **margen de ganancia** (10%) para servicios propios. | Aplica **recargo de gestión** (5%) para subcontratados. |
| `obtenerDetalle()` | Descripción base. | Detalle con el **stock propio**. | Detalle con el nombre del **proveedor**. |

3. Polimorfismo Dinámico

El Polimorfismo Dinámico** (Dynamic Binding) se demuestra en el `Main.java` y en el método `calcularCostoTotalGlobal()` del `GestorServicios`.

Ejemplo de Código (en `Main.java`):**
```java
// Bucle sobre referencias de tipo ServicioBase
for (ServicioBase servicio : gestor.getListaServicios()) {
    System.out.println(servicio.obtenerDetalle()); // <--- Dynamic Binding
    servicio.calcularCostoTotal();                 // <--- Dynamic Binding
}