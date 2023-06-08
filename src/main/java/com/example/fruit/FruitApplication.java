package com.example.fruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.fruit.controller", "com.example.fruit.service"})

public class FruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitApplication.class, args);
	}

}
