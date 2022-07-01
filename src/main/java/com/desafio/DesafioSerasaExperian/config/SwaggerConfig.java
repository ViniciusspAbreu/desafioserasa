package com.desafio.DesafioSerasaExperian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.desafio.DesafioSerasaExperian.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API Desafio Serasa Experian",
                "Criar um serviço do tipo API REST, para cadastro de pessoas com score e suas regiões de afinidades",
                "Versão 1.0",
                "vinicius",
                new Contact("Vinicius de Abreu", "vinicius.abreu@linkedin", "vini_ciusbraga@hotmail.com"),
                "Permitida",
                "Vinicius",
                Collections.emptyList() // Vendor Extensions
        );
    }
}
