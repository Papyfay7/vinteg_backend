package com.vinteg.vinteg_app.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.vinteg.vinteg_app.controller") // Remplacez par le package de vos contrôleurs
                .build();
    }

    @Bean
    public OpenApiCustomizer customizer() {
        return openApi -> {
            openApi.info(apiInfo());
            // Ajoutez d'autres personnalisations OpenAPI ici si nécessaire
        };
    }

    @Bean
    public Info apiInfo() {
        return new Info()
                .title("Spring Boot REST API")
                .description("Spring Boot REST API for Online Store")
                .version("1.0.0")
                .license(new License().name("Apache License Version 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("John Thompson").url("https://springframework.guru/about/").email("john@springframework.guru"));
    }

    @Bean
    public ExternalDocumentation externalDocs() {
        return new ExternalDocumentation()
                .description("Documentation Complète de l'API")
                .url("http://localhost:8080/v3/api-docs/public");
    }
}