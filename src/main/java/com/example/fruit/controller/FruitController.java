package com.example.fruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruit.model.Fruit;
import com.example.fruit.service.FruitService;

@RestController
@RequestMapping("/fruit")

public class FruitController {

    
    @Autowired
    private FruitService service;

    @PostMapping
    public Fruit createFruit(@RequestBody Fruit fruit) {
        return service.addFruit(fruit);
    }

    @GetMapping
    public List<Fruit> getFruit() {
        return service.getFruits();
    }

    // @GetMapping("/fruit/{name}")
    // public List<Fruit> findFruitUsingName(String name) {
    //     return service.getFruitByName(name);
    // }

    @PutMapping("/update")
    public Fruit modifyFruit(@RequestBody Fruit fruit) {
        return service.updateFruit(fruit);
    }

    @DeleteMapping("/delete/{fruitId}")
    public String deleteFruit(@PathVariable String fruitId) {
        return service.deleteFruit(fruitId);
    }


}
