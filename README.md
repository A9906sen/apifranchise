# apifranchise
Esta es una API desarrollada en **Java con Spring Boot** para la gestión de franquicias. El sistema permite administrar **sucursales**, y cada sucursal tiene su propio inventario de **productos**.

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- MongoDB

## 🧱 Estructura del sistema

```mermaid
graph TD
    A[Franquicia] --> B[Sucursal]
    B --> C[Producto]
