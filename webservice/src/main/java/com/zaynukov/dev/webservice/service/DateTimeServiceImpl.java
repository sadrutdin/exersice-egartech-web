package com.zaynukov.dev.webservice.service;

import com.zaynukov.dev.webservice.ws.request.GetCurrentDateTimeRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    @Override
    public String getCurrentDateTime(GetCurrentDateTimeRequest response) {
        return ZonedDateTime.now(ZoneId.of(response.getTimeZone())).format(dateTimeFormatter);
    }
}
