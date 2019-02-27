
package com.zaynukov.dev.ws.currentdatetime.obj.response;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for GetCurrentDateTimeResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCurrentDateTimeResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCurrentDateTimeResponse", propOrder = {
        "currentDateTime"
})
@XmlRootElement(name="GetCurrentDateTimeResponse", namespace = "http://current-date-time.ws.dev.zaynukov.com")
public class GetCurrentDateTimeResponse {
    public GetCurrentDateTimeResponse() {
    }

    public GetCurrentDateTimeResponse(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @XmlElement(required = true)
    protected String currentDateTime;

    /**
     * Gets the value of the currentDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentDateTime() {
        return currentDateTime;
    }

    /**
     * Sets the value of the yourDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentDateTime(String value) {
        this.currentDateTime = value;
    }

}
