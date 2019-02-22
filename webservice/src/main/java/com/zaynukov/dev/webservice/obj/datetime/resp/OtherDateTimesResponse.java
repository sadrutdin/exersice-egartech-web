
package com.zaynukov.dev.webservice.obj.datetime.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for other-datetimeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="other-datetimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datetime" type="{}datetimeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "other-datetimeType", propOrder = {
        "datetime"
})
public class OtherDateTimesResponse {

    protected List<DateTimeItemReponse> datetime;

    /**
     * Gets the value of the datetime property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datetime property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatetime().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateTimeItemReponse }
     */
    public List<DateTimeItemReponse> getDatetime() {
        if (datetime == null) {
            datetime = new ArrayList<DateTimeItemReponse>();
        }
        return this.datetime;
    }

}
