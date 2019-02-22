
package com.zaynukov.dev.webservice.obj.datetime.resp;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for currentDateTimesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="currentDateTimesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="yourDateTime" type="{}yourDateTimeType"/>
 *         &lt;element name="otherDateTime" type="{}otherDateTimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currentDateTimesType", propOrder = {
    "yourDateTime",
    "otherDateTime"
})
@XmlRootElement(name="currentDateTimes", namespace = "http://dateservice.ws.dev.zaynukov.com")
public class CurrentDateTimeRootResponse {
    public CurrentDateTimeRootResponse() {
    }

    public CurrentDateTimeRootResponse(YourDateTimeResponse yourDateTime, OtherDateTimeResponse otherDateTime) {
        this.yourDateTime = yourDateTime;
        this.otherDateTime = otherDateTime;
    }

    @XmlElement(required = true)
    protected YourDateTimeResponse yourDateTime;
    @XmlElement(required = true)
    protected OtherDateTimeResponse otherDateTime;

    /**
     * Gets the value of the yourDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link YourDateTimeResponse }
     *     
     */
    public YourDateTimeResponse getYourDateTime() {
        return yourDateTime;
    }

    /**
     * Sets the value of the yourDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link YourDateTimeResponse }
     *     
     */
    public void setYourDateTime(YourDateTimeResponse value) {
        this.yourDateTime = value;
    }

    /**
     * Gets the value of the otherDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link OtherDateTimeResponse }
     *     
     */
    public OtherDateTimeResponse getOtherDateTime() {
        return otherDateTime;
    }

    /**
     * Sets the value of the otherDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherDateTimeResponse }
     *     
     */
    public void setOtherDateTime(OtherDateTimeResponse value) {
        this.otherDateTime = value;
    }

}
