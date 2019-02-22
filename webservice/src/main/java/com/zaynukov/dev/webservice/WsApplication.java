package com.zaynukov.dev.webservice;

import com.zaynukov.dev.webservice.obj.datetime.req.CurrentDateTimeRootRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@SpringBootApplication
public class WsApplication {

    public static void main(String[] args) throws JAXBException {
        SpringApplication.run(WsApplication.class, args);



 /*       JAXBContext jContext = JAXBContext.newInstance(CurrentDateTimeRootRequest.class);
        //creating the marshaller object
        Marshaller marshallObj = jContext.createMarshaller();
        //setting the property to show xml format output
        marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //setting the values in POJO class
        CurrentDateTimeRootRequest utc = new CurrentDateTimeRootRequest("UTC");

        StringWriter sw = new StringWriter();
        marshallObj.marshal(utc,sw);
        System.out.println(sw.toString());*/

    }

}
