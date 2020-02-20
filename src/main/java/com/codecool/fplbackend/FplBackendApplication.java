package com.codecool.fplbackend;

import com.codecool.fplbackend.service.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class FplBackendApplication {
    @Autowired
    private DataInitializer initializer;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FplBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            initializer.initialize();
        };
    }
}
