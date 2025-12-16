# Proyecto Final: Sistema de Gestión de Eventos (POO + Persistencia)

## 👤 Información del Estudiante
| Campo | Valor                                                    |
|-------|----------------------------------------------------------|
| **Nombre** | [Yesid StevenValencia Rodriguez]                         |
| **Ficha** | [3228970 A]                                              |
| **Dominio** | Gestión de Eventos (Quince Años, Matrimonio, Cumpleaños) |
| **Fecha** | [09/09/2025]                                             |

---
## 📝 Descripción del Sistema

Este proyecto implementa un sistema para la gestión de servicios dentro de una agencia organizadora de eventos. El sistema permite registrar diferentes tipos de servicios (Internos y Externos), calcular sus costos totales (incluyendo márgenes o comisiones), y gestionar la colección de servicios de manera eficiente.

**Mejora clave (Persistencia):** Utiliza I/O y Serialización para asegurar que la lista de servicios se guarda automáticamente al cerrar la aplicación y se carga al iniciar. La lógica de negocio (`GestorServicios`) aplica colecciones avanzadas (`HashMap` y `ArrayList`) y Streams para optimizar las operaciones.

---
## 🏗️ Arquitectura del Proyecto

### Diagrama de Clases


### Estructura de Paquetes
| Paquete | Contenido | Clases Clave |
|---------|-----------|--------|
| `modelo` | Entidades del negocio (Serializables) | `ServicioBase` (Abstracta), `ServicioInterno`, `ServicioExterno` |
| `servicio` | Lógica de negocio y Persistencia | `GestorServicios` |
| `excepciones` | Excepciones personalizadas | `CostoInvalidoException`, `ServicioNoEncontradoException` |
| `interfaces` | Contratos para Polimorfismo | `IContratable`, `IReportable` |

---
## 🧬 Aplicación de Conceptos POO

### Encapsulación
- Todos los atributos de las clases modelo son `protected` o `private`.
- **Validaciones implementadas:**
    1. Validación en constructor: El `costoBase` debe ser `> 0` (lanza `CostoInvalidoException`).
    2. Validación en `GestorServicios.agregar`: Evita duplicados de código (lanza `IllegalArgumentException`).

### Herencia
| Clase Padre | Clases Hijas | Atributos Heredados |
|-------------|--------------|---------------------|
| `ServicioBase` (Abstracta) | `ServicioInterno`, `ServicioExterno` | `nombre`, `costoBase`, `descripcion`, `codigo` |

### Polimorfismo
**Sobrescritura (@Override):**
- `calcularCostoTotal()`: Sobrescrito en `ServicioInterno` y `ServicioExterno` para aplicar márgenes o comisiones.
- `obtenerDetalleCompleto()`: Implementado en las clases hijas para dar detalles específicos.
  **Colecciones polimórficas:**
- `List<ServicioBase>` y `Map<String, ServicioBase>` contienen instancias de `ServicioInterno` y `ServicioExterno`.

### Abstracción
| Tipo | Nombre | Implementaciones |
|------|--------|------------------|
| Clase abstracta | `ServicioBase` | `ServicioInterno`, `ServicioExterno` |
| Interface | `IContratable` | `ServicioBase` |
| Interface | `IReportable` | `ServicioInterno` |

### Excepciones Personalizadas
| Excepción | Tipo | Cuándo se lanza |
|-----------|------|-----------------|
| `CostoInvalidoException` | Checked | Si el costo de un servicio es `<= 0` al crearlo. |
| `ServicioNoEncontradoException` | Checked | Si se busca un servicio cuyo código no existe. |

### Colecciones
| Colección | Tipo | Propósito |
|-----------|------|-----------|
| `serviciosPorCodigo` | `Map<String, ServicioBase>` | Búsqueda **O(1)** por código de servicio. |
| `historialServicios` | `List<ServicioBase>` | Mantiene el orden de inserción y permite **Filtrado** con Streams. |

---
## 📋 Funcionalidades del Sistema

| Operación | Descripción | Estado |
|-----------|-------------|--------|
| Agregar servicio | Crea y añade un nuevo servicio con validación de costo y duplicado. | ✅ |
| **Buscar por código** | Acceso directo O(1) vía HashMap. | ✅ |
| Listar todos | Muestra todos los servicios del historial. | ✅ |
| Eliminar | Remueve el servicio de ambas colecciones. | ✅ |
| **Filtrar por rango** | Usa Streams para obtener servicios en un rango de precio. | ✅ |
| **Estadísticas** | Calcula promedio y encuentra el servicio más caro. | ✅ |
| **Persistencia** | Carga y guarda la colección automáticamente usando Serialización. | ✅ |

---

## 🚀 Cómo Ejecutar

### Compilación (Terminal)
```bash
cd proyecto-final
javac -d bin src/com/eventos/manager/*/*.java src/com/eventos/manager/*.java