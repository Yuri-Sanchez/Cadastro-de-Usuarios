package com.sanchez.cruddeusuarios.Config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration{
    @Bean
    public OpenAPI openInfo(){
        return new OpenAPI()
                .info(
                        new Info()
                            .title("Cadastro de usuários")
                            .description("Api para cadastro de usuários")
                            .version("1.0.0")
                );
    }
}
