package com.reto.apiretofranquicia.Domain.Ports.input;

import com.reto.apiretofranquicia.Application.DTO.ProductoConSucursal;
import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import java.util.List;

public interface IFranquiciaService {
    Franquicia addFranquicia(Franquicia franquicia);
    List<Franquicia> getAllFranquicias();
    Sucursal addSucursal(String nombreFranquicia, Sucursal sucursal);
    Producto addProducto(String nombreFranquicia, String nombreSucursal, Producto producto);
    boolean deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
    Producto updateStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int nuevoStock);
    List<ProductoConSucursal> getMaxStockPorSucursal(String nombreFranquicia);
}