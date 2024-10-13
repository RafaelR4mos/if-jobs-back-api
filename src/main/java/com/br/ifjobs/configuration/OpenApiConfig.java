package com.br.ifjobs.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title(appName)
                        .version("v1")
                        .description("Documentação Spring Boot 3.3.4 " + appName)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")
                        )
                );
    }
}
