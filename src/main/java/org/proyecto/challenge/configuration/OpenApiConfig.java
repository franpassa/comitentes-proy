package org.proyecto.challenge.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Comitentes API", description = "API con operaciones CRUD sobre comitentes y mercados.", version = "1.0.0")
)
public class OpenApiConfig {

}