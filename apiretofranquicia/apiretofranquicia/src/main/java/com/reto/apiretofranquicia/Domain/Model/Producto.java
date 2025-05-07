package com.reto.apiretofranquicia.Domain.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private String nombre;
    private int stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }
}