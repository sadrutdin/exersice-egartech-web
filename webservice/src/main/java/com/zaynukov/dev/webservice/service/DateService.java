package com.zaynukov.dev.webservice.service;

import com.zaynukov.dev.webservice.obj.datetime.req.CurrentDateTimeRootRequest;
import com.zaynukov.dev.webservice.obj.datetime.resp.CurrentDateTimeRootResponse;

public interface DateService {
    CurrentDateTimeRootResponse currentDates(CurrentDateTimeRootRequest response);
}
