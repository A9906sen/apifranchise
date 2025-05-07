package com.reto.apiretofranquicia.Adapter.Persistence.Mongodb;

import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Model.Producto;
import com.reto.apiretofranquicia.Domain.Model.Sucursal;
import com.reto.apiretofranquicia.Domain.Ports.output.IFranquiciaRepository;
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
}
