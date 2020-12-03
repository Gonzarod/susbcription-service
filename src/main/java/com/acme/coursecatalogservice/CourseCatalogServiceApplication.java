package com.acme.coursecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CourseCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseCatalogServiceApplication.class, args);
    }

}
