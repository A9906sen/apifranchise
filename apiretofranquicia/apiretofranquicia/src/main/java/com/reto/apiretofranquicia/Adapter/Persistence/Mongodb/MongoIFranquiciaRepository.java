package com.reto.apiretofranquicia.Adapter.Persistence.Mongodb;

import com.reto.apiretofranquicia.Domain.Model.Franquicia;
import com.reto.apiretofranquicia.Domain.Ports.output.IFranquiciaRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class MongoIFranquiciaRepository implements IFranquiciaRepository {

    private final MongoTemplate mongoTemplate;

    public MongoIFranquiciaRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Franquicia save(Franquicia franquicia){
        return mongoTemplate.save(franquicia);
    }

    @Override
    public List<Franquicia> findAll(){
        return mongoTemplate.findAll(Franquicia.class);
    }

    @Override
    public Optional<Franquicia> findByName(String nombre) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        Query.query(Criteria.where("name").is(nombre)),
                        Franquicia.class
                )
        );
    }

}
