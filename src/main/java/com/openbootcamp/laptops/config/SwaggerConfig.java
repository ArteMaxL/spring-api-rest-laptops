package com.openbootcamp.laptops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuracion Swagger
 * HTML : http://localhost:8080/swagger-ui/
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Demo de API REST con SpringBoot en Heroku",
                "1.0",
                "http://www.google.com.ar",
                new Contact("Artemio","http://www.google.com.ar","arte@mio.com"),
                "MIT",
                "http://www.google.com.ar",
                Collections.emptyList());
    }
}
