# apifranchise
Esta es una API desarrollada en **Java con Spring Boot** para la gestión de **franquicias**, el sistema permite administrar las **sucursales** de cada una, y asu vez cada sucursal tiene su propio inventario de **productos**.


##  Tecnologías utilizadas

- Java 17+
- Spring Boot
- MongoDB

##  Estructura del sistema

 DB Local
- Mongo DB Community Edition
- Modelo:
  {"_id":{"$oid":"67e8a1bf1c78189a9ab09521"},"nombre":"Franquicia A","sucursales":[{"nombre":"Sucursal Norte","productos":[{"nombre":"Producto 1","stock":{"$numberInt":"20"}},{"nombre":"Producto 2","stock":{"$numberInt":"15"}}]},{"nombre":"Sucursal Sur","productos":[{"nombre":"Producto 3","stock":{"$numberInt":"50"}},{"nombre":"Producto 4","stock":{"$numberInt":"30"}}]}]}
  
  **En application.properties se indica las dos formas de conectarse, ya sea por mongo db atlas o compass**

  link documentación endpoints: https://myoffice.accenture.com/personal/andrea_c_peralta_accenture_com/_layouts/15/download.aspx?UniqueId=31df47fb389746ecbdd2526511fe5898&e=oJ8Iss

```mermaid
classDiagram
class Franquicia {
+String id
+String nombre
+List~Sucursal~ sucursales
}
class Sucursal {
+String nombre
+List~Producto~ productos
}
class Producto {
+String nombre
+Integer stock
}
Franquicia "1" *-- "*" Sucursal
Sucursal "1" *-- "*" Producto


