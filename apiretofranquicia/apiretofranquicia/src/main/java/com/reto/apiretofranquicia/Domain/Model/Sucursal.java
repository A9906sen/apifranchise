package com.reto.apiretofranquicia.Domain.Model;

import java.util.List;

public class Sucursal{
    private String nombre;
    private List<Producto> productos;

    public Sucursal(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
