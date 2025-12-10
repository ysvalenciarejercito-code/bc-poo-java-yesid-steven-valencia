# Semana 08: Colecciones y Generics - Gestión de Eventos

## 👤 Información del Estudiante
- **Nombre**: Yesid Steven Valencia
- **Ficha**: [3228970]
- **Dominio**: Gestión de Eventos (Quince Años, Matrimonio, Cumpleaños)
- **Fecha**: [21/06/2023]

## 📝 Descripción del Proyecto

El sistema de Gestión de Eventos fue refactorizado para migrar a **Colecciones profesionales (HashMap y ArrayList)**, utilizando **Generics** (`<T>`) para garantizar la seguridad de tipos. Esto permitió implementar operaciones eficientes de **búsqueda O(1)** (usando la clave del `HashMap`) y nuevas funcionalidades de **filtrado** y **estadísticas** usando la API de **Streams** de Java 8+.

## 📦 Colecciones Utilizadas

### HashMap
- **`Map<String, ServicioBase> serviciosPorCodigo`**: Utilizado en `GestorServicios` para permitir la **búsqueda instantánea (O(1))** de un servicio usando su código único como clave. También se usa para la **validación de duplicados**.

### ArrayList
- **`List<ServicioBase> historialServicios`**: Utilizado para mantener una colección secuencial y ordenada de todos los servicios agregados. Es la base para las operaciones de **filtrado** (con Streams) y **estadísticas**.

## 🔍 Operaciones Implementadas

### CRUD con Colecciones
- ✅ **Agregar** con validación de duplicados (`if (map.containsKey())`).
- ✅ **Buscar por clave O(1)** con `HashMap.get(codigo)`.
- ✅ **Eliminar** por código (sincronizando `HashMap.remove()` y `ArrayList.remove()`).

### Filtrado
- ✅ **Filtrar por rango de precio** (Implementado usando `Stream.filter()`).

### Estadísticas
- ✅ **Promedio de precios** (Implementado usando `Stream.mapToDouble()` y `summaryStatistics()`).
- ✅ **Elemento más caro** (Implementado usando `Stream.max()` con un `Comparator`).

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-08
# Compilación: Compila todos los archivos .java en los subdirectorios
javac -d bin src/com/eventos/manager/*/*.java src/com/eventos/manager/*.java
# Ejecución
java -cp bin com.eventos.manager.Main