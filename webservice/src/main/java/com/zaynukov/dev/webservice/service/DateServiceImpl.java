package com.zaynukov.dev.webservice.service;

import com.zaynukov.dev.webservice.obj.datetime.req.CurrentDateTimeRootRequest;
import com.zaynukov.dev.webservice.obj.datetime.resp.CurrentDateTimeRootResponse;
import com.zaynukov.dev.webservice.obj.datetime.resp.DateTimeItemResponse;
import com.zaynukov.dev.webservice.obj.datetime.resp.OtherDateTimeResponse;
import com.zaynukov.dev.webservice.obj.datetime.resp.YourDateTimeResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DateServiceImpl implements DateService {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    @Override
    public CurrentDateTimeRootResponse currentDates(CurrentDateTimeRootRequest response) {
        String timeZone = response.getMyTimeZone();

        OffsetDateTime dateObject = OffsetDateTime.now(ZoneOffset.UTC);

        Map<String, String> currentDatesMap = new LinkedHashMap<>(47);
        for (int i = -23; i <= 23; i++) {
            String key, value;
            if (i < 0) key = "UTC" + i;
            else if (i > 0) key = "UTC+" + i;
            else key = "UTC";

            value = dateObject.minusHours(i).format(dateTimeFormatter);

            currentDatesMap.put(key, value);
        }
        String userCurrentDateTime = currentDatesMap.get(timeZone);


        YourDateTimeResponse yourDateTimeResponse = new YourDateTimeResponse(userCurrentDateTime, timeZone);

        OtherDateTimeResponse otherDateTimesReponse = new OtherDateTimeResponse();
        List<DateTimeItemResponse> otherDateTimeList = otherDateTimesReponse.getDateTime();

        for (Map.Entry<String, String> entry : currentDatesMap.entrySet()) {
            otherDateTimeList.add(new DateTimeItemResponse(entry.getKey(), entry.getValue()));
        }

        return new CurrentDateTimeRootResponse(yourDateTimeResponse, otherDateTimesReponse);
    }
}
