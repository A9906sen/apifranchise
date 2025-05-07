package com.reto.apiretofranquicia.Adapter.Web;

import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.input.IFranquiciaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {
    private List<Franquicia> franquicias = new ArrayList<>();
    private final IFranquiciaService franquiciaService;

    public FranquiciaController(IFranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public Franquicia addFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.addFranquicia(franquicia);
    }

    @GetMapping
    public List<Franquicia> getAllFranquicias() {
        return franquiciaService.getAllFranquicias();
    }

    @PostMapping("/{nombreFranquicia}/sucursales")
    public Sucursal addSucursal(@PathVariable String nombreFranquicia, @RequestBody Sucursal sucursal) {
        return franquiciaService.addSucursal(nombreFranquicia, sucursal);
    }

    @PostMapping("/{nombreFranquicia}/sucursales/{nombreSucursal}/productos")
    public Producto addProducto(@PathVariable String nombreFranquicia,
                                    @PathVariable String nombreSucursal,
                                    @RequestBody Producto producto) {
        return franquiciaService.addProducto(nombreFranquicia, nombreSucursal, producto);
    }

}
