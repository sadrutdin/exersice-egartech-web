
package com.zaynukov.dev.webservice.obj.datetime.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zaynukov.dev.webservice.obj.datetime.req package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MyCurrentDateTime_QNAME = new QName("", "myCurrentDateTime");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zaynukov.dev.webservice.obj.datetime.req
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CurrentDateTimeRootRequest }
     * 
     */
    public CurrentDateTimeRootRequest createMyCurrentDateTimeType() {
        return new CurrentDateTimeRootRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentDateTimeRootRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "myCurrentDateTime")
    public JAXBElement<CurrentDateTimeRootRequest> createMyCurrentDateTime(CurrentDateTimeRootRequest value) {
        return new JAXBElement<CurrentDateTimeRootRequest>(_MyCurrentDateTime_QNAME, CurrentDateTimeRootRequest.class, null, value);
    }

}
