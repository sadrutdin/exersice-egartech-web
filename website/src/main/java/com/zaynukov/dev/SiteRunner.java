package com.zaynukov.dev;

import com.zaynukov.dev.ws.currentdatetime.DateTimeWsClientService;
import com.zaynukov.dev.ws.currentdatetime.DateTimeWsClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.zaynukov.dev.service.product.repository")
public class SiteRunner {

    private static final Logger logger = LoggerFactory.getLogger(SiteRunner.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SiteRunner.class, args);
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.zaynukov.dev.ws.currentdatetime.obj");
        return marshaller;
    }

    @Bean
    public DateTimeWsClientService dateTimeWsClientService(Jaxb2Marshaller marshaller) {
        return new DateTimeWsClientServiceImpl(
                "http://127.0.0.1:8080/ws",
                marshaller
        );

    }
}
