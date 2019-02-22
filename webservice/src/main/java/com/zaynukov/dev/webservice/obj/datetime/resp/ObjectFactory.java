
package com.zaynukov.dev.webservice.obj.datetime.resp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.zaynukov.dev.webservice.obj.datetime.resp package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CurrentDatetimes_QNAME = new QName("", "current-datetimes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zaynukov.dev.webservice.obj.datetime.resp
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CurrentDateTimeRootResponse }
     */
    public CurrentDateTimeRootResponse createCurrentDatetimesType() {
        return new CurrentDateTimeRootResponse();
    }

    /**
     * Create an instance of {@link YourDateTimeResponse }
     */
    public YourDateTimeResponse createYourDatetimeType() {
        return new YourDateTimeResponse();
    }

    /**
     * Create an instance of {@link DateTimeItemReponse }
     */
    public DateTimeItemReponse createDatetimeType() {
        return new DateTimeItemReponse();
    }

    /**
     * Create an instance of {@link OtherDateTimesResponse }
     */
    public OtherDateTimesResponse createOtherDatetimeType() {
        return new OtherDateTimesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentDateTimeRootResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "current-datetimes")
    public JAXBElement<CurrentDateTimeRootResponse> createCurrentDatetimes(CurrentDateTimeRootResponse value) {
        return new JAXBElement<CurrentDateTimeRootResponse>(_CurrentDatetimes_QNAME, CurrentDateTimeRootResponse.class, null, value);
    }

}
