package com.reto.apiretofranquicia.Adapter.Web;

import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Ports.input.ISucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {
    private final ISucursalService ISucursalService;

    public SucursalController(ISucursalService ISucursalService) {
        this.ISucursalService = ISucursalService;
    }

   /* @PostMapping("/productos")
    public ResponseEntity<String> agregarProducto(@RequestBody Producto producto) {
        ISucursalService.agregarProducto(producto);
        return ResponseEntity.ok("Producto agregado exitosamente");
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> consultarProductos() {
        List<Producto> productos = ISucursalService.consultarProductos();
        return ResponseEntity.ok(productos);
    }*/
}
