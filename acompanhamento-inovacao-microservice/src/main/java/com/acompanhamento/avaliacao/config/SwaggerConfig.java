package com.acompanhamento.avaliacao.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API - Acompanhamento e Avaliação")
                .version("1.0")
                .description("Registra o progresso e avaliação de ideias ou projetos.")
                .contact(new Contact()
                        .name("Tary Nascimento")
                        .email("tary.nascimento@recife.pe.gov.br")
                        .url("https://github.com/TN-Junior")
                )
        );
    }
}
