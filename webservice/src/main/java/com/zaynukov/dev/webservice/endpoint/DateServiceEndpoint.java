package com.zaynukov.dev.webservice.endpoint;

import com.zaynukov.dev.webservice.service.DateTimeService;
import com.zaynukov.dev.webservice.ws.request.GetCurrentDateTimeRequest;
import com.zaynukov.dev.webservice.ws.response.GetCurrentDateTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DateServiceEndpoint {
    private static final String NAMESPACE_URI = "http://current-date-time.ws.dev.zaynukov.com";

    private final DateTimeService dateTimeService;

    public DateServiceEndpoint() {
        dateTimeService = null;
    }

    @Autowired
    public DateServiceEndpoint(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @SuppressWarnings("unused")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCurrentDateTimeRequest")
    @ResponsePayload()
    public GetCurrentDateTimeResponse getCurrentDateTime(@RequestPayload GetCurrentDateTimeRequest request) {
        GetCurrentDateTimeResponse getCurrentDateTimeResponse = new GetCurrentDateTimeResponse();
        getCurrentDateTimeResponse.setCurrentDateTime(dateTimeService.getCurrentDateTime(request));

        return getCurrentDateTimeResponse;
    }
}
