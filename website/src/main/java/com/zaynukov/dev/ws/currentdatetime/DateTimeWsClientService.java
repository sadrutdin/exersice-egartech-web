package com.zaynukov.dev.ws.currentdatetime;

import com.zaynukov.dev.ws.currentdatetime.obj.response.GetCurrentDateTimeResponse;

public interface DateTimeWsClientService {
    GetCurrentDateTimeResponse getCurrentDateTime(String timeZone);
}
