
package com.zaynukov.dev.webservice.obj.datetime.resp;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for current-datetimesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="current-datetimesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="your-datetime" type="{}your-datetimeType"/>
 *         &lt;element name="other-datetime" type="{}other-datetimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "current-datetimesType", propOrder = {
        "yourDatetime",
        "otherDatetime"
})
@XmlRootElement(namespace = "http://ns.dev.zaynukov.com/", name = "current-datetimes")
public class CurrentDateTimeRootResponse {

    public CurrentDateTimeRootResponse() {
    }

    public CurrentDateTimeRootResponse(YourDateTimeResponse yourDatetime, OtherDateTimesResponse otherDatetime) {
        this.yourDatetime = yourDatetime;
        this.otherDatetime = otherDatetime;
    }

    @XmlElement(name = "your-datetime", required = true)
    protected YourDateTimeResponse yourDatetime;
    @XmlElement(name = "other-datetime", required = true)
    protected OtherDateTimesResponse otherDatetime;

    /**
     * Gets the value of the yourDatetime property.
     *
     * @return possible object is
     * {@link YourDateTimeResponse }
     */
    public YourDateTimeResponse getYourDatetime() {
        return yourDatetime;
    }

    /**
     * Sets the value of the yourDatetime property.
     *
     * @param value allowed object is
     *              {@link YourDateTimeResponse }
     */
    public void setYourDatetime(YourDateTimeResponse value) {
        this.yourDatetime = value;
    }

    /**
     * Gets the value of the otherDatetime property.
     *
     * @return possible object is
     * {@link OtherDateTimesResponse }
     */
    public OtherDateTimesResponse getOtherDatetime() {
        return otherDatetime;
    }

    /**
     * Sets the value of the otherDatetime property.
     *
     * @param value allowed object is
     *              {@link OtherDateTimesResponse }
     */
    public void setOtherDatetime(OtherDateTimesResponse value) {
        this.otherDatetime = value;
    }

}
