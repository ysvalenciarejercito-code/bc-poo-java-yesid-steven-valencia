# Análisis Orientado a Objetos - Empresa de Eventos "Celebraciones Especiales"

## 1. Identificación del Dominio

**Nombre del negocio:** Celebraciones Especiales
**Tipo:** Organización y Coordinación Integral de Eventos Sociales y Corporativos.
**Descripción:** Empresa dedicada a planificar, coordinar y ejecutar eventos (bodas, cumpleaños, empresariales) en Bogotá. Su modelo se basa en la gestión interna de organizadores y la colaboración con proveedores externos para servicios específicos (catering, decoración).

## 2. Objetos Identificados

### Objeto Principal: Evento

**¿Qué es?:** Es la unidad central de negocio. Representa el servicio principal planificado y vendido al cliente. Es el eje alrededor del cual gira toda la operación de la empresa.

**Atributos identificados:**
- `codigo`: String - Identificador único para referenciar el evento internamente.
- `tipo`: String - Categoría del evento (e.g., "Boda", "Empresarial").
- `asistentes`: int - Número de invitados esperados, fundamental para cotizaciones y logística.
- `costoBase`: double - Monto estimado inicial de los servicios sin recargos.
- `activo`: boolean - Indica si el evento está en planificación/ejecución (`true`) o ya finalizó (`false`).
- `lugar`: String - Ubicación física donde se desarrollará el evento.

**Métodos identificados:**
- `mostrarInformacion()`: void - Imprime un resumen de los detalles clave del evento para revisión.
- `calcularCostoTotal()`: double - Retorna el costo base más un porcentaje de gastos operativos (valor calculado).
- `getCodigo()`: String - Permite obtener el identificador único del evento (getter).
- `setActivo(boolean activo)`: void - Permite cambiar el estado del evento (setter).

### Objeto Secundario: Cliente

**¿Qué es?:** La entidad (persona o empresa) que contrata, financia y aprueba la realización del Evento. Sin Cliente, no hay Evento.

**Atributos identificados:**
- `idCliente`: String - Identificador único del cliente.
- `nombreCompleto`: String - Nombre del contacto principal o razón social.
- `correo`: String - Vía de comunicación principal.
- `tipoCliente`: String - Clasificación para segmentación ("Social" o "Empresarial").
- `eventosContratados`: int - Contador de eventos previos, útil para fidelización (e.g., clientes VIP).

**Métodos identificados:**
- `mostrarDatos()`: void - Presenta la información de contacto y clasificación del cliente.
- `contratarEvento()`: boolean - Incrementa el contador de eventos y verifica si califica como VIP (valor calculado).
- `actualizarCorreo(String nuevoCorreo)`: void - Modifica el email de contacto.

## 3. Relación entre Objetos

**Tipo de relación:** **Asociación (Uno a Muchos: Un Cliente puede contratar Cero o Muchos Eventos).**

**Descripción:** Un objeto `Cliente` puede estar asociado a múltiples objetos `Evento`. El `Evento` es contratado por el `Cliente`, por lo que cada instancia de `Evento` necesita conocer a qué `Cliente` se le debe facturar y quién es el contacto para la aprobación de la planificación. En una implementación más avanzada, la clase `Evento` contendría una referencia al objeto `Cliente`.

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Elegí **Evento** como principal porque es el **producto/servicio esencial** que vende la empresa. Elegí **Cliente** como secundario porque es la **entidad que consume** ese servicio y genera los ingresos. Ambos son imprescindibles para modelar el núcleo de negocio ("Celebraciones Especiales").

**¿Por qué estos atributos son importantes?**
* **Evento:** `codigo` y `tipo` son esenciales para la gestión. `asistentes` y `costoBase` son críticos para la logística y finanzas. `activo` permite un control de estado del proceso de planificación/ejecución.
* **Cliente:** `nombreCompleto` y `correo` son la base de la comunicación. `tipoCliente` y `eventosContratados` son vitales para la estrategia comercial y segmentación.

**¿Por qué estos métodos son necesarios?**
* **Evento:** `mostrarInformacion()` y `calcularCostoTotal()` son acciones de gestión y cotización fundamentales en una empresa de eventos. Los `getter` y `setter` permiten la manipulación controlada del estado del evento.
* **Cliente:** `contratarEvento()` simula la acción clave del cliente y permite hacer cálculos de fidelización (VIP), que es una lógica de negocio importante.

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Se manejaría un solo archivo `main.c` (o similar) con funciones como `calcular_costo_total(asistentes, costo_base)` y `mostrar_evento(codigo, tipo, asistentes, activo)`. Los datos del Evento y del Cliente se guardarían en **variables separadas** o en **arrays desordenados**. Por ejemplo:
`String evento_codigo[50];`
`int evento_asistentes[50];`
`String cliente_nombre[50];`
Sería muy difícil relacionar el índice 5 del array de clientes con el índice 5 del array de eventos de forma segura y legible, generando código extenso y propenso a errores.

**Con POO:**
Utilizando las clases `Evento` y `Cliente`, encapsulamos los datos (atributos) y las operaciones (métodos) que les son propios. Por ejemplo, al crear un objeto `Evento evento1`, este objeto **contiene** su propio `codigo`, `asistantes`, `costoBase`, y las funciones para operarlos (`calcularCostoTotal()`). Esto mejora la **modularidad**, la **reutilización** y la **coherencia** de los datos.

**Ventajas específicas en mi dominio:**
1.  **Reutilización:** Si se necesita crear otro tipo de evento (e.g., "Grado"), no se altera el código base; simplemente se crea una nueva instancia de la clase `Evento`.
2.  **Organización y Mantenimiento:** La lógica de facturación (`calcularCostoTotal()`) está *dentro* del objeto `Evento` y la lógica de fidelización (`contratarEvento()`) está *dentro* del objeto `Cliente`. Esto facilita la modificación y el mantenimiento del código sin afectar otras partes del sistema (encapsulamiento).
3.  **Representación Fiel:** Los objetos del código (`Evento`, `Cliente`) se mapean directamente a las entidades del mundo real de la empresa, haciendo el código más intuitivo y fácil de entender por cualquier desarrollador.

## 6. Diagrama de Clases (Opcional)