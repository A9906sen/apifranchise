# apifranchise
Esta es una API desarrollada en **Java con Spring Boot** para la gestión de franquicias. El sistema permite administrar **sucursales**, y cada sucursal tiene su propio inventario de **productos**.


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

classDiagram
class FranquiciaController {
<<RestController>>
+addFranquicia(Franquicia) ResponseEntity<Franquicia>
+getAllFranquicias() ResponseEntity<List<Franquicia>>
+addSucursal(String, Sucursal) ResponseEntity<Sucursal>
+addProducto(String, String, Producto) ResponseEntity<Producto>
+actualizarStock(String, String, String, Map~String,Integer~) ResponseEntity<Producto>
+eliminarProducto(String, String, String) ResponseEntity~Void~
}

class FranquiciaService {
<<Interface>>
+addFranquicia(Franquicia) Franquicia
+getAllFranquicias() List<Franquicia>
+addSucursal(String, Sucursal) Sucursal
+addProducto(String, String, Producto) Producto
+actualizarStock(String, String, String, int) Optional<Producto>
+eliminarProducto(String, String, String) boolean
}

class FranquiciaServiceImpl {
-repository: IFranquiciaRepository
+actualizarStock(...) Optional<Producto>
+eliminarProducto(...) boolean
}

class FranquiciaMongoRepository {
-mongoTemplate: MongoTemplate
+save(Franquicia) Franquicia
+findAll() List<Franquicia>
+actualizarStock(...) Optional<Producto>
}

class Franquicia {
-String id
-String nombre
-List~Sucursal~ sucursales
}

class Sucursal {
-String nombre
-List~Producto~ productos
}

class Producto {
-String nombre
-Integer stock
}

FranquiciaController --> FranquiciaService
FranquiciaService <|.. FranquiciaServiceImpl
FranquiciaServiceImpl --> IFranquiciaRepository
IFranquiciaRepository <|.. FranquiciaMongoRepository
Franquicia "1" *-- "*" Sucursal
Sucursal "1" *-- "*" Producto
