package com.reto.apiretofranquicia.Domain.Ports.output;

import com.reto.apiretofranquicia.Application.DTO.ProductoConSucursal;
import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import java.util.List;
import java.util.Optional;

public interface IFranquiciaRepository {
    Franquicia save(Franquicia franquicia);
    List<Franquicia> findAll();
    Sucursal addSucursal(String nombreFranquicia, Sucursal sucursal);
    Producto addProducto(String nombreFranquicia, String nombreSucursal, Producto producto);
    Optional<Franquicia> findByName(String nombre);
    boolean deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
    Producto updateStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int nuevoStock);
    List<ProductoConSucursal> findMaxStockPorSucursal(String nombreFranquicia);
}