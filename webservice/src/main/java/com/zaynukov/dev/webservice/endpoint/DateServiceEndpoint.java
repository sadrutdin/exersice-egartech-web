package com.zaynukov.dev.webservice.endpoint;

import com.zaynukov.dev.webservice.obj.datetime.req.CurrentDateTimeRootRequest;
import com.zaynukov.dev.webservice.obj.datetime.resp.CurrentDateTimeRootResponse;
import com.zaynukov.dev.webservice.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DateServiceEndpoint {
    private static final String NAMESPACE_URI = "http://ns.dev.zaynukov.com/";

    private final DateService dateService;

//    public DateServiceEndpoint() {
//        dateService = null;
//    }

    @Autowired
    public DateServiceEndpoint(DateService dateService) {
        this.dateService = dateService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "my-current-datetime")
    @ResponsePayload
    public CurrentDateTimeRootResponse currentDate(@RequestPayload CurrentDateTimeRootRequest request) {
        return dateService.currentDates(request);
    }
}
