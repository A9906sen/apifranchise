package com.reto.apiretofranquicia.Application;

import com.reto.apiretofranquicia.Application.DTO.ProductoConSucursal;
import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.input.IFranquiciaService;
import com.reto.apiretofranquicia.Domain.Ports.output.IFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements IFranquiciaService {
    private final IFranquiciaRepository repository;

    @Override
    public Franquicia addFranquicia(Franquicia franquicia) {
        return repository.save(franquicia);
    }

    @Override
    public List<Franquicia> getAllFranquicias() {
        return repository.findAll();
    }

    @Override
    public Sucursal addSucursal(String nombreFranquicia, Sucursal sucursal) {
        return repository.addSucursal(nombreFranquicia, sucursal);
    }

    @Override
    public Producto addProducto(String nombreFranquicia, String nombreSucursal, Producto producto) {
        return repository.addProducto(nombreFranquicia, nombreSucursal, producto);
    }

    @Override
    public boolean deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
        return repository.deleteProducto(nombreFranquicia, nombreSucursal, nombreProducto);
    }

    @Override
    public Producto updateStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int nuevoStock) {
        return repository.updateStock(nombreFranquicia, nombreSucursal, nombreProducto, nuevoStock);
    }

    @Override
    public List<ProductoConSucursal> getMaxStockPorSucursal(String nombreFranquicia){
        return repository.findMaxStockPorSucursal(nombreFranquicia);
    }
}
