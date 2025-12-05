# Semana 02 - Clases y Relaciones (ArrayList)

## 📝 Descripción

Se extendió el modelo de dominio con las clases `Organizador` y `Servicio`, y se establecieron relaciones:
1.  **Composición/Agregación:** `Evento` tiene un `Organizador` y una colección de `Servicio` (usando `ArrayList`).
2.  **Repositorio Central:** Se creó la clase `GestorEventos` para mantener un `ArrayList` de todos los objetos `Evento`.

## 🎯 Objetivos Cumplidos

- [x] Implementar clases secundarias (`Organizador.java`, `Servicio.java`)
- [x] Implementar clase gestora (`GestorEventos.java`)
- [x] Establecer relación 1:N (Composición) en `Evento` usando `ArrayList`.
- [x] Implementar método de negocio que itera la colección (`contarEventosActivos`).

## 📂 Archivos Entregados

- `src/Evento.java` - Clase principal (actualizada con `ArrayList<Servicio>`).
- `src/GestorEventos.java` - Clase gestora central (`ArrayList<Evento>`).
- `src/Organizador.java` - Clase que modela al personal de logística.
- `src/Servicio.java` - Clase que modela los ítems contratables.
- `src/Main.java` - Programa de demostración que usa todas las relaciones.

## 🚀 Instrucciones de Ejecución

```bash
cd src
javac *.java
java Main