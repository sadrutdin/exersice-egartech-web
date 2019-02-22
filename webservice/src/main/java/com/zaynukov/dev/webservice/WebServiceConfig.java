package com.zaynukov.dev.webservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.Servlet;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "currentDates")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema currentDateSchema) {
        DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
        wsdlDefinition.setPortTypeName("DateServicePort");
        wsdlDefinition.setLocationUri("/ws");
        wsdlDefinition.setTargetNamespace("http://dateservice.ws.dev.zaynukov.com");
        wsdlDefinition.setSchema(currentDateSchema);
        return wsdlDefinition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("datetime-all.xsd"));
    }
}
