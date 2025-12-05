# Semana 03 - Encapsulación y Constructores

## 📝 Descripción

Refactorización completa de todas las clases del dominio para implementar los pilares de la Encapsulación y la Flexibilidad del constructor. Todos los atributos son privados y se han implementado Getters y Setters con validaciones estrictas.

## 🎯 Objetivos Cumplidos

- [x] Encapsulación completa (todos los atributos `private`).
- [x] Implementación de *Getters* para todos los atributos.
- [x] Sobrecarga de constructores (mínimo 2 por clase principal).
- [x] Implementación de **Validaciones** en *setters* y constructores (`throw new IllegalArgumentException`).
- [x] Documentar las mejoras en el archivo `MEJORAS.md`.

## 📂 Archivos Entregados

- `src/Evento.java` - Clase principal (refactorizada con 3 constructores sobrecargados y validaciones).
- `src/Cliente.java` - Clase secundaria (refactorizada con 3 constructores sobrecargados y validaciones).
- `src/Organizador.java` - (Refactorizada con 2 constructores y validaciones).
- `src/Servicio.java` - (Refactorizada con 2 constructores y validaciones).
- `src/GestorEventos.java` - (Actualizada para usar los *getters*).
- `src/Main.java` - Programa de demostración de sobrecarga y uso de *setters*.
- `docs/MEJORAS.md` - Documento de análisis de las mejoras implementadas.

## 🚀 Instrucciones de Ejecución

```bash
cd src
javac *.java
java Main