package com.zaynukov.dev.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);

//        try {
//            JavaToWS.main(new String[] { "-d", "src", "-o", "date_service.wsdl", "-createxsdimports", "-wsdl",
//                    "com.zaynukov.dev.webservice.endpoint.DateServiceEndpoint", });
//            System.out.println("finished %%%%%%%%%%");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
