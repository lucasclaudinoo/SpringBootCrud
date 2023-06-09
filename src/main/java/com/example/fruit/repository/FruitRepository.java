package com.example.fruit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.fruit.model.Fruit;

import java.util.List;



public interface FruitRepository extends MongoRepository<Fruit, String> {
    

    @Query("{'name': ?0}")
    List<Fruit> findByName(String name);
    
    @Query("{'idFruits': ?0}")
    List<Fruit> findByIdFruits(String idFruits);
}
