package br.com.senai.autoescolan321.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration // A classe securityConfigurations, vai gerenciar essa configuração
public class WebConfigurations {

    //@Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            //@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "https://meudominio.com.br",
                                "http://131.128.191.223:8080")

                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("Authorization", "Content-Type", "Accept", "Origin")
                        .allowCredentials(true);
            }

        };
    }
}
