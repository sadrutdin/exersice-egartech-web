package com.zaynukov.dev.webservice.service;

import com.zaynukov.dev.webservice.ws.request.GetCurrentDateTimeRequest;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

    @Override
    public String getCurrentDateTime(GetCurrentDateTimeRequest response) {
        try {
            return ZonedDateTime.now(ZoneId.of(response.getTimeZone())).format(dateTimeFormatter);
        } catch (Exception e) {
            return ZonedDateTime.now(ZoneOffset.UTC).format(dateTimeFormatter);
        }
    }
}
