package com.Bootcamp.RESTfulWebservices.Controller;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger/OpenAPI configuration class.
 * This class configures the Swagger documentation for the RESTful Web Services application.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful Web Services API")
                        .version("1.0.0")
                        .description("RESTful Web Services API Documentation with support for " +
                                "Internationalization, Content Negotiation, Versioning, Filtering, and HATEOAS")
                        .contact(new Contact()
                                .name("Bootcamp Team")
                                .email("bootcamp@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
