
package com.zaynukov.dev.webservice.obj.datetime.req;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for my-current-datetimeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="my-current-datetimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="my-timezone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "my-current-datetimeType", propOrder = {
        "myTimezone"
})
@XmlRootElement(namespace = "http://ns.dev.zaynukov.com/", name = "my-current-datetime")
public class CurrentDateTimeRootRequest {
    public CurrentDateTimeRootRequest() {
    }

    public CurrentDateTimeRootRequest(String myTimezone) {
        this.myTimezone = myTimezone;
    }

    @XmlElement(name = "my-timezone", required = true)
    protected String myTimezone;

    /**
     * Gets the value of the myTimezone property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMyTimezone() {
        return myTimezone;
    }

    /**
     * Sets the value of the myTimezone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMyTimezone(String value) {
        this.myTimezone = value;
    }

}
