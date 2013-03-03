
package currency.soapclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetConversionRateResult" type="{http://www.restfulwebservices.net/DataContracts/2008/01}Currency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getConversionRateResult"
})
@XmlRootElement(name = "GetConversionRateResponse")
public class GetConversionRateResponse {

    @XmlElementRef(name = "GetConversionRateResult", namespace = "http://www.restfulwebservices.net/ServiceContracts/2008/01", type = JAXBElement.class)
    protected JAXBElement<Currency> getConversionRateResult;

    /**
     * Gets the value of the getConversionRateResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Currency }{@code >}
     *     
     */
    public JAXBElement<Currency> getGetConversionRateResult() {
        return getConversionRateResult;
    }

    /**
     * Sets the value of the getConversionRateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Currency }{@code >}
     *     
     */
    public void setGetConversionRateResult(JAXBElement<Currency> value) {
        this.getConversionRateResult = ((JAXBElement<Currency> ) value);
    }

}
