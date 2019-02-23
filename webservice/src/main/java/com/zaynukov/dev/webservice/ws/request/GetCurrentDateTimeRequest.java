
package com.zaynukov.dev.webservice.ws.request;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for GetCurrentDateTimeRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetCurrentDateTimeRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "timeZone"
})
@XmlRootElement(name = "GetCurrentDateTimeRequest", namespace = "http://current-date-time.ws.dev.zaynukov.com")
public class GetCurrentDateTimeRequest {
    public GetCurrentDateTimeRequest() {
    }

    public GetCurrentDateTimeRequest(String timeZone) {
        this.timeZone = timeZone;
    }

    @XmlElement(required = true, namespace = "http://current-date-time.ws.dev.zaynukov.com")
    protected String timeZone;

    /**
     * Gets the value of the timeZone property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

}
