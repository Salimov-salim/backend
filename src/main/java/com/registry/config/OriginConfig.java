package com.registry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OriginConfig {

    @Bean
    public WebMvcConfigurer configurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET","POST", "OPTIONS", "PUT", "PATCH", "DELETE")
                        .allowedHeaders("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN")
                        .allowCredentials(true)
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }

}