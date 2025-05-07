package com.reto.apiretofranquicia.Application;

import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.input.IFranquiciaService;
import com.reto.apiretofranquicia.Domain.Ports.output.IFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements IFranquiciaService {
    private List<Franquicia> franquicias = new ArrayList<>();
    private final IFranquiciaRepository repository;

    @Override
    public Franquicia addFranquicia(Franquicia franquicia){
        return repository.save(franquicia);
    }

    @Override
    public List<Franquicia> getAllFranquicias(){
        return repository.findAll();
    }

    @Override
    public Sucursal addSucursal(String nombreFranquicia, Sucursal sucursal) {
        Franquicia franquicia = searchFranquicia(nombreFranquicia);
        if (franquicia != null) {
            franquicia.getSucursales().add(sucursal);
            return sucursal;
        }
        return null;
    }

    @Override
    public Producto addProducto(String nombreFranquicia, String nombreSucursal, Producto producto) {
        Franquicia franquicia = searchFranquicia(nombreFranquicia);
        if (franquicia != null) {
            Sucursal sucursal = searchSucursal(franquicia, nombreSucursal);
            if (sucursal != null) {
                sucursal.getProductos().add(producto);
                return producto;
            }
        }
        return null;
    }

    public Franquicia obtenerFranquicia(String nombreFranquicia) {
        return searchFranquicia(nombreFranquicia);
    }

    private Franquicia searchFranquicia(String nombre) {
        return franquicias.stream()
                .filter(f -> f.getName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    private Sucursal searchSucursal(Franquicia franquicia, String nombreSucursal) {
        return franquicia.getSucursales().stream()
                .filter(s -> s.getName().equalsIgnoreCase(nombreSucursal))
                .findFirst()
                .orElse(null);

    }

}
