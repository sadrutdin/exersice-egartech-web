
package com.zaynukov.dev.webservice.obj.datetime.req;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for myCurrentDateTimeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="myCurrentDateTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="myTimeZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myCurrentDateTimeType", propOrder = {
    "myTimeZone"
})
@XmlRootElement(name="myCurrentDateTime", namespace = "http://dateservice.ws.dev.zaynukov.com")
public class CurrentDateTimeRootRequest {
    public CurrentDateTimeRootRequest() {
    }

    public CurrentDateTimeRootRequest(String myTimeZone) {
        this.myTimeZone = myTimeZone;
    }

    @XmlElement(required = true)
    protected String myTimeZone;

    /**
     * Gets the value of the myTimeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyTimeZone() {
        return myTimeZone;
    }

    /**
     * Sets the value of the myTimeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyTimeZone(String value) {
        this.myTimeZone = value;
    }

}
