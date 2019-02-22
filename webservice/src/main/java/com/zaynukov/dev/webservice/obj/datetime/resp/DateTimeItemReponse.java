
package com.zaynukov.dev.webservice.obj.datetime.resp;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for datetimeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="datetimeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datetimeType", propOrder = {
        "value"
})
public class DateTimeItemReponse {

    public DateTimeItemReponse() {
    }

    public DateTimeItemReponse(String timezone, String value) {
        this.value = value;
        this.timezone = timezone;
    }

    @XmlValue
    protected String value;
    @XmlAttribute(name = "timezone")
    protected String timezone;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the timezone property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

}
