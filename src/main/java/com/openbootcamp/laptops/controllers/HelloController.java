package com.openbootcamp.laptops.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/")
    public String saludar(){
        System.out.println(message);
        return """
                <h1>Hola SpringBoot!</h1>
                </br>
                <h3>Demo de Aplicacion con Spring Security</h3>
                <p>Solo user: admin, password: 12345</p>
                <p>Tiene acceso completo al CRUD y a Swagger</p>
                <a href="https://spring-api-rest-aptop.herokuapp.com/swagger-ui/">Swagger Docs</a>
                </br>
                <a href="https://spring-api-rest-aptop.herokuapp.com/api/laptops">CRUD Laptops</a>
                </br>
                <p>Solo user: user, password: 123</p>
                <p>Tiene acceso al CRUD</p>
                """;
    }
}
