package com.zaynukov.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.zaynukov.dev.service.product.repository")
public class SiteRunner {

    private static final Logger logger = LoggerFactory.getLogger(SiteRunner.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SiteRunner.class, args);
    }


}
