package com.zaynukov.dev.ws.currentdatetime;

import com.zaynukov.dev.ws.currentdatetime.obj.GetCurrentDateTimeRequestType;
import com.zaynukov.dev.ws.currentdatetime.obj.GetCurrentDateTimeResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

//@Service
public class DateTimeWsClientServiceImpl
        extends WebServiceGatewaySupport
        implements DateTimeWsClientService, java.io.Serializable {

    public DateTimeWsClientServiceImpl(String defaultUri, Marshaller marshaller, Unmarshaller unmarshaller) {
        super.setDefaultUri(defaultUri);
        super.setMarshaller(marshaller);
        super.setUnmarshaller(unmarshaller);
    }

    public DateTimeWsClientServiceImpl(String defaultUri, Jaxb2Marshaller marshallerAndUnmarshaller) {
        this(defaultUri, marshallerAndUnmarshaller, marshallerAndUnmarshaller);
    }

    private static final Logger log = LoggerFactory.getLogger(DateTimeWsClientServiceImpl.class);

    @Override
    public GetCurrentDateTimeResponseType getCurrentDateTime(String timeZone) {
        GetCurrentDateTimeRequestType request = new GetCurrentDateTimeRequestType();
        request.setTimeZone(timeZone);

        log.info("Requesting location for '" + timeZone + '\'');

        //noinspection unchecked
        JAXBElement<GetCurrentDateTimeResponseType> obj =
                (JAXBElement<GetCurrentDateTimeResponseType>) super.getWebServiceTemplate()
                        .marshalSendAndReceive(
                                "http://127.0.0.1:8080/ws",
                                request //, new SoapActionCallback("http://127.0.0.1:8080/ws/GetCurrentDateTimeRequest")
                        );
        return obj.getValue();
    }
}
