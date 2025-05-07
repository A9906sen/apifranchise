package com.reto.apiretofranquicia.Adapter.Web;

import com.reto.apiretofranquicia.Application.DTO.ProductoConSucursal;
import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.input.IFranquiciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {
    private final IFranquiciaService franquiciaService;

    public FranquiciaController(IFranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public ResponseEntity<Franquicia> addFranquicia(
            @RequestBody Franquicia franquicia,
            UriComponentsBuilder uriBuilder
    ) {
        Franquicia nuevaFranquicia = franquiciaService.addFranquicia(franquicia);
        URI location = uriBuilder.path("/api/franquicias/{id}")
                .buildAndExpand(nuevaFranquicia.getId())
                .toUri();
        return ResponseEntity.created(location).body(nuevaFranquicia);
    }

    @GetMapping
    public ResponseEntity<List<Franquicia>> getAllFranquicias() {
        return ResponseEntity.ok(franquiciaService.getAllFranquicias());
    }

    @PostMapping("/{nombreFranquicia}/sucursales")
    public ResponseEntity<Sucursal> addSucursal(
            @PathVariable String nombreFranquicia,
            @RequestBody Sucursal sucursal
    ) {
        Sucursal nuevaSucursal = franquiciaService.addSucursal(nombreFranquicia, sucursal);
        if (nuevaSucursal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nuevaSucursal);
    }

    @PostMapping("/{nombreFranquicia}/sucursales/{nombreSucursal}/productos")
    public ResponseEntity<Producto> addProducto(
            @PathVariable String nombreFranquicia,
            @PathVariable String nombreSucursal,
            @RequestBody Producto producto
    ) {
        Producto nuevoProducto = franquiciaService.addProducto(nombreFranquicia, nombreSucursal, producto);
        if (nuevoProducto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nuevoProducto);
    }

    @DeleteMapping("/{nombreFranquicia}/sucursales/{nombreSucursal}/productos/{nombreProducto}")
    public ResponseEntity<Void> deleteProducto(
            @PathVariable String nombreFranquicia,
            @PathVariable String nombreSucursal,
            @PathVariable String nombreProducto
    ) {
        boolean eliminado = franquiciaService.deleteProducto(nombreFranquicia, nombreSucursal, nombreProducto);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{nombreFranquicia}/sucursales/{nombreSucursal}/productos/{nombreProducto}/stock")
    public ResponseEntity<Producto> updateStock(
            @PathVariable String nombreFranquicia,
            @PathVariable String nombreSucursal,
            @PathVariable String nombreProducto,
            @RequestBody int nuevoStock
    ) {
        Producto productoActualizado = franquiciaService.updateStock(nombreFranquicia, nombreSucursal, nombreProducto, nuevoStock);
        if (productoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoActualizado);
    }

    @GetMapping("/{nombreFranquicia}/productos-mayor-stock")
    public ResponseEntity<List<ProductoConSucursal>> getMaxStockPorSucursal(@PathVariable String nombreFranquicia) {
        List<ProductoConSucursal> productos = franquiciaService.getMaxStockPorSucursal(nombreFranquicia);
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productos);
    }
}
