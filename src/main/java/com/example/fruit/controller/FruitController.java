package com.example.fruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.fruit.model.Fruit;
import com.example.fruit.service.FruitService;

@RestController
@RequestMapping("/")

public class FruitController {

    @GetMapping("fruit/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/index");
        
        List<Fruit> fruits = service.getFruits();
        modelAndView.addObject("fruits", fruits);
        
        return modelAndView;
    }


    @GetMapping("/getById/{fruitId}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String fruitId) {
        Fruit fruit = service.getFruitById(fruitId);
        if (fruit != null) {
            return ResponseEntity.ok(fruit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
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
    public String modifyFruit(@RequestBody Fruit fruit) {
        service.updateFruit(fruit);
        return "redirect:/fruit/home";
    }

    @DeleteMapping("/delete/{fruitId}")
    public String deleteFruit(@PathVariable String fruitId) {
        return service.deleteFruit(fruitId);
    }


}
