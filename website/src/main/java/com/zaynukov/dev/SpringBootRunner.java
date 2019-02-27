package com.zaynukov.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.rmi.RemoteException;

@SpringBootApplication
@EnableJpaRepositories("com.zaynukov.dev.service.product.repository")
public class SpringBootRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootRunner.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootRunner.class, args);
    }

}
