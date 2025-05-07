# apifranchise
Esta es una API desarrollada en **Java con Spring Boot** para la gestión de **franquicias**, el sistema permite administrar las **sucursales** de cada una, y asu vez cada sucursal tiene su propio inventario de **productos**.


## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- MongoDB

## 🧱 Estructura del sistema

 DB Local
- Mongo DB Community Edition
  {"_id":{"$oid":"67e8a1bf1c78189a9ab09521"},"nombre":"Franquicia A","sucursales":[{"nombre":"Sucursal Norte","productos":[{"nombre":"Producto 1","stock":{"$numberInt":"20"}},{"nombre":"Producto 2","stock":{"$numberInt":"15"}}]},{"nombre":"Sucursal Sur","productos":[{"nombre":"Producto 3","stock":{"$numberInt":"50"}},{"nombre":"Producto 4","stock":{"$numberInt":"30"}}]}]}
  En application.properties se indica las dos formas de conectarse, ya sea por mongo db atlas o compass

```mermaid
graph TD
    A[Franquicia] --> B[Sucursal]
    B --> C[Producto]


