package com.reto.apiretofranquicia.Domain.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "franquicias")
public class Franquicia {
    @Id
    private String id;
    private String nombre;
    private List<Sucursal> sucursales = new ArrayList<>();

    public Franquicia(String id, String nombre, List<Sucursal> sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
