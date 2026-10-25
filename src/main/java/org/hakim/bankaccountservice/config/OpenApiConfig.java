package org.hakim.bankaccountservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankAccountOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Bank Account Service API")
                .description("Micro-service de gestion des comptes bancaires")
                .version("1.0"));
    }
}
