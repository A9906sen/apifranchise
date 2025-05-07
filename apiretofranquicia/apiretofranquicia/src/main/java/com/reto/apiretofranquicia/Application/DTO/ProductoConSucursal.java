package com.reto.apiretofranquicia.Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoConSucursal {
    private String nombre;
    private int stock;
    private String nombreSucursal;
}


