package com.zaynukov.dev.webservice.service;

import com.zaynukov.dev.webservice.ws.request.GetCurrentDateTimeRequest;

public interface DateService {
    String getCurrentDateTime(GetCurrentDateTimeRequest response);
}
