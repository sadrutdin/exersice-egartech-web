package com.zaynukov.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zaynukov.dev.service.product.repository")
public class SpringBootRunner {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootRunner.class, args);
    }

}
