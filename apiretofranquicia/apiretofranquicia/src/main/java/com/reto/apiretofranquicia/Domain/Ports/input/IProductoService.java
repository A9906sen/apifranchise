package com.reto.apiretofranquicia.Domain.Ports.input;

import com.reto.apiretofranquicia.Domain.Model.Producto;

import java.util.List;

public interface IProductoService {
    void agregarProducto(Producto producto);
    List<Producto> consultarProductos();
}
