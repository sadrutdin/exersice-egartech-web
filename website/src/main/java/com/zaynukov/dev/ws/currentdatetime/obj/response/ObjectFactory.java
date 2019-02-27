
package com.zaynukov.dev.ws.currentdatetime.obj.response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCurrentDateTimeResponse_QNAME = new QName("", "GetCurrentDateTimeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zaynukov.dev.webservice.obj.datetime.resp
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrentDateTimeResponse }
     */
    public GetCurrentDateTimeResponse createGetCurrentDateTimeResponse() {
        return new GetCurrentDateTimeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentDateTimeResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "GetCurrentDateTimeResponse")
    public JAXBElement<GetCurrentDateTimeResponse> createGetCurrentDateTimeResponse(
            GetCurrentDateTimeResponse value) {
        return new JAXBElement<GetCurrentDateTimeResponse>(_GetCurrentDateTimeResponse_QNAME, GetCurrentDateTimeResponse.class, null, value);
    }

}
