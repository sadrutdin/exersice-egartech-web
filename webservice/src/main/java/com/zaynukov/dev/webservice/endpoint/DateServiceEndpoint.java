package com.zaynukov.dev.webservice.endpoint;

import com.zaynukov.dev.webservice.ws.request.GetCurrentDateTimeRequest;
import com.zaynukov.dev.webservice.ws.response.GetCurrentDateTimeResponse;
import com.zaynukov.dev.webservice.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DateServiceEndpoint {
    private static final String NAMESPACE_URI = "http://current-date-time.ws.dev.zaynukov.com";

    private final DateService dateService;

    public DateServiceEndpoint() {
        dateService = null;
    }

    @Autowired
    public DateServiceEndpoint(DateService dateService) {
        this.dateService = dateService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCurrentDateTimeRequest")
    @ResponsePayload
    public GetCurrentDateTimeResponse getCurrentDateTime(@RequestPayload GetCurrentDateTimeRequest request) {
        GetCurrentDateTimeResponse getCurrentDateTimeResponse = new GetCurrentDateTimeResponse();
        getCurrentDateTimeResponse.setCurrentDateTime(dateService.getCurrentDateTime(request));

        return getCurrentDateTimeResponse;
    }
}
