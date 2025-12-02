package br.com.senai.autoescola_n321.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer").bearerFormat("JWT"))
                )
                .info(new Info().title("API REST Autoescola N321")
                        .contact(new Contact()
                                .name("Izabely Lourenço")
                                .email("izabely.lourenco@outlook.com"))
                        .license(new License().name("Apache 2.0")
//                                .url("https://autoescolan321.com.br/license")
                        ));
    }
}
