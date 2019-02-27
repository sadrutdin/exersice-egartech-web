package com.zaynukov.dev.ws.currentdatetime;

import com.zaynukov.dev.ws.currentdatetime.obj.GetCurrentDateTimeResponseType;

public interface DateTimeWsClientService {
    GetCurrentDateTimeResponseType getCurrentDateTime(String timeZone);
}
