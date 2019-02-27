
package com.zaynukov.dev.ws.currentdatetime.obj.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCurrentDateTimeRequest_QNAME = new QName("", "GetCurrentDateTimeRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zaynukov.dev.webservice.obj.datetime.req
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrentDateTimeRequest }
     */
    public GetCurrentDateTimeRequest createGetCurrentDateTimeRequestType() {
        return new GetCurrentDateTimeRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentDateTimeRequest }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "GetCurrentDateTimeRequest")
    public JAXBElement<GetCurrentDateTimeRequest> createGetCurrentDateTimeRequest(
            GetCurrentDateTimeRequest value) {
        return new JAXBElement<GetCurrentDateTimeRequest>(_GetCurrentDateTimeRequest_QNAME, GetCurrentDateTimeRequest.class, null, value);
    }

}
