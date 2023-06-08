package com.example.fruit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "fruit")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fruit {
    
   @Id
    private String fruitId;
    public String name;
    private String amount;
}
