package com.reto.apiretofranquicia.Domain.Model;

import java.util.ArrayList;
import java.util.List;

public class Sucursal{
    private String name;
    private List<Producto> productos;

    public Sucursal(String name) {
        this.name = name;
        this.productos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
