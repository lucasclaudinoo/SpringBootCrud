package com.example.fruit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fruit.model.Fruit;
import com.example.fruit.repository.FruitRepository;

@Service

public class FruitService {
    
    @Autowired
    private FruitRepository repository;

    public Fruit addFruit(Fruit fruit) {

        // String existFruit = fruit.getName();
        
        // if (existFruit != null) {
        //     throw new IllegalStateException("Fruit already exists");
        // }

        // else {
            fruit.setFruitId(UUID.randomUUID().toString().split("-")[0]);
            return repository.save(fruit);
        // }
    }

    public List<Fruit> getFruits() {
        return repository.findAll();
    }
    
    public List<Fruit> getFruitByName(String name) {
        return repository.findByName(name);
    }

    public String deleteFruit(String id) {
        repository.deleteById(id);
        return "Fruit removed !! " + id;
    }

    public Fruit updateFruit(Fruit fruit) {
        Fruit existingFruit = repository.findById(fruit.getFruitId()).orElse(null);
        existingFruit.setName(fruit.getName());
        existingFruit.setAmount(fruit.getName());
        return repository.save(existingFruit);
    }

}
