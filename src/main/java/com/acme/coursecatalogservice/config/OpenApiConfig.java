package com.acme.coursecatalogservice.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean(name = "courseCatalogOpenApi")
    public OpenAPI courseCatalogOpenApi() {
        // Available at
        // http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Documentation of Crehana Course Catalog Service").description(
                        "Documentation using springdoc-openapi and OpenAPI 3."));
    }
}
