package com.reto.apiretofranquicia.Domain.Model;

import java.util.ArrayList;
import java.util.List;

public class Franquicia {
    String name;
    private List<Sucursal> sucursales;

    public Franquicia(String name, List<Sucursal> sucursales) {
        this.name = name;
        this.sucursales = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public void addSucursal(Sucursal sucursal) {
    }
}
