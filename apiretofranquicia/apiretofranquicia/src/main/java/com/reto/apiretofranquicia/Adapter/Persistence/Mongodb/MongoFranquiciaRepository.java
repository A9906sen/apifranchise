package com.reto.apiretofranquicia.Adapter.Persistence.Mongodb;

import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.output.IFranquiciaRepository;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MongoFranquiciaRepository implements IFranquiciaRepository {
    private final MongoTemplate mongoTemplate;

    public MongoFranquiciaRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Franquicia save(Franquicia franquicia) {
        return mongoTemplate.save(franquicia);
    }

    @Override
    public List<Franquicia> findAll() {
        return mongoTemplate.findAll(Franquicia.class);
    }

    @Override
    public Sucursal addSucursal(String nombreFranquicia, Sucursal sucursal) {
        Query query = Query.query(Criteria.where("nombre").is(nombreFranquicia));
        Update update = new Update().push("sucursales", sucursal);
        mongoTemplate.updateFirst(query, update, Franquicia.class);
        return sucursal;
    }

    @Override
    public Producto addProducto(String nombreFranquicia, String nombreSucursal, Producto producto) {
        Query query = Query.query(
                Criteria.where("nombre").is(nombreFranquicia)
                        .and("sucursales.nombre").is(nombreSucursal)
        );
        Update update = new Update().push("sucursales.$.productos", producto);
        mongoTemplate.updateFirst(query, update, Franquicia.class);
        return producto;
    }

    @Override
    public Optional<Franquicia> findByName(String nombre) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        Query.query(Criteria.where("nombre").is(nombre)),
                        Franquicia.class
                )
        );
    }

    @Override
    public boolean deleteProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
        Query query = Query.query(
                Criteria.where("nombre").is(nombreFranquicia)
                        .and("sucursales.nombre").is(nombreSucursal)
        );
        Update update = new Update().pull("sucursales.$.productos", new Document("nombre", nombreProducto));
        return mongoTemplate.updateFirst(query, update, Franquicia.class).getModifiedCount() > 0;
    }

    @Override
    public Producto updateStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int nuevoStock) {
        Franquicia franquicia = mongoTemplate.findOne(
                Query.query(Criteria.where("nombre").is(nombreFranquicia)),
                Franquicia.class
        );

        if (franquicia == null) return null;

        for (Sucursal sucursal : franquicia.getSucursales()) {
            if (sucursal.getNombre().equalsIgnoreCase(nombreSucursal)) {
                for (Producto producto : sucursal.getProductos()) {
                    if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                        producto.setStock(nuevoStock);
                        mongoTemplate.save(franquicia);
                        return producto;
                    }
                }
            }
        }

        return null;
    }

}