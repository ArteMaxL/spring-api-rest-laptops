package com.openbootcamp.laptops.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/api/saludo")
    public String saludar(){
        System.out.println(message);
        return "<h1>Hola OpenBootcamp!</h1>";
    }
}
