package com.acme.catchup.platform.shared.infrastructure.configuration.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Central OpenAPI metadata shared by all bounded contexts.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI catchUpPlatformOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Catch-Up Platform API")
                        .version("1.0.1")
                        .description("REST API documentation for the Catch-up Platform bounded contexts.")
                        .contact(new Contact().name("Catch-up Platform Team"))
                        .license(new License().name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
