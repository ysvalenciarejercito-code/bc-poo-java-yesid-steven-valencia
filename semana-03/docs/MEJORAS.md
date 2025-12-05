# Mejoras Implementadas - Semana 03: Encapsulación y Constructores

## Encapsulación Aplicada (Ejercicio 1)

Todos los atributos de las clases principales (`Cliente`, `Evento`, `Organizador`, `Servicio`) han sido declarados como `private` y su acceso está controlado estrictamente por métodos *Getters* y *Setters*.

### Clase: Cliente
- **Atributos encapsulados:** `idCliente`, `nombreCompleto`, `correo`, `tipoCliente`, `eventosContratados`.
- **Validaciones agregadas:** Se implementaron validaciones en *Setters* y el constructor principal para asegurar la integridad de los datos, como verificar que los *String* no sean vacíos y que el formato del correo sea válido.

### Clase: Evento
- **Atributos encapsulados:** `codigo`, `tipo`, `asistentes`, `costoBase`, `activo`, `lugar`, `organizadorAsignado`, `serviciosContratados`.
- **Validaciones agregadas:** Se valida que el número de `asistentes` y el `costoBase` sean valores positivos o cero, previniendo la creación de objetos inválidos.

## Constructores Sobrecargados (Ejercicio 2)

Se implementaron al menos dos constructores sobrecargados en las clases principales, utilizando el patrón `this(...)` para llamar al constructor principal y garantizar la reutilización de código.

### Clase: Cliente
- **Constructor 1 (Completo):** Inicializa todos los datos esenciales, aplicando validaciones.
- **Constructor 2 (Básico):** `Cliente(String id, String nombre, String email)` - Asume el `tipoCliente` como "Social" por defecto.
- **Constructor 3 (Mínimo):** `Cliente(String id, String nombre)` - Genera el correo automáticamente y establece el tipo "Social".

### Clase: Evento
- **Constructor 1 (Completo):** Inicializa todos los atributos y asigna el organizador.
- **Constructor 2 (Cotización Rápida):** `Evento(String codigo, String tipo, int asistentes)` - Útil para pre-registro, establece costo base cero y lugar "Pendiente".

## Beneficios Logrados

1.  **Integridad de Datos:** El uso del patrón `throw new IllegalArgumentException` dentro de *setters* y constructores asegura que el sistema rechace datos inválidos (Ej: costo negativo o asistentes cero) tan pronto como se intenta crear o modificar el objeto.
2.  **Flexibilidad:** La sobrecarga de constructores simplifica la creación de objetos, permitiendo al sistema adaptarse a diferentes fases de trabajo (registro completo vs. cotización inicial).
3.  **Mantenibilidad:** La encapsulación y el uso de *setters* validados centralizan la lógica de negocio, haciendo que los cambios sean menos propensos a introducir errores en otras partes del código.