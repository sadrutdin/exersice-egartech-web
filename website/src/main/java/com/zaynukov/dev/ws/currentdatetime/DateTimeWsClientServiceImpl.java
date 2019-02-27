package com.zaynukov.dev.ws.currentdatetime;

import com.zaynukov.dev.ws.currentdatetime.obj.request.GetCurrentDateTimeRequest;
import com.zaynukov.dev.ws.currentdatetime.obj.response.GetCurrentDateTimeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.annotation.PostConstruct;

@Service
public class DateTimeWsClientServiceImpl
        implements DateTimeWsClientService, java.io.Serializable {

    @PostConstruct
    private void init() {
        dateTimeServiceTemplate.setDefaultUri("http://127.0.0.1:8080/ws");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();

        marshaller.setContextPaths("com.zaynukov.dev.ws.currentdatetime.obj.request");
        unmarshaller.setContextPath("com.zaynukov.dev.ws.currentdatetime.obj.response");

        dateTimeServiceTemplate.setMarshaller(marshaller);
        dateTimeServiceTemplate.setUnmarshaller(unmarshaller);
    }

    private static final Logger log = LoggerFactory.getLogger(DateTimeWsClientServiceImpl.class);

    private WebServiceTemplate dateTimeServiceTemplate = new WebServiceTemplate();

    @Override
    public GetCurrentDateTimeResponse getCurrentDateTime(String timeZone) {
        GetCurrentDateTimeRequest request = new GetCurrentDateTimeRequest(timeZone);

        log.info("Requesting location for '" + timeZone + '\'');

        return (GetCurrentDateTimeResponse) dateTimeServiceTemplate.marshalSendAndReceive(request);
    }
}
