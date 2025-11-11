package com.basketball.referee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CABA-Pro Basketball Referee Management API")
                        .version("1.0.0")
                        .description("REST API for managing basketball referees, tournaments, matches, and assignments. " +
                                "This system helps coordinate referee assignments, track performance grades, and manage tournament schedules.")
                        .contact(new Contact()
                                .name("CABA-Pro Team")
                                .email("support@caba-pro.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Development Server")));
    }
}
