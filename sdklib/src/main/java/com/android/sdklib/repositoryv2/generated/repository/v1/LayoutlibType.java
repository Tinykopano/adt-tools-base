//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.18 at 04:02:54 PM PST 
//


package com.android.sdklib.repositoryv2.generated.repository.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Version information for a layoutlib included in a platform.
 *             
 * 
 * <p>Java class for layoutlibType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="layoutlibType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="api" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "layoutlibType")
@SuppressWarnings({
    "override",
    "unchecked"
})
public class LayoutlibType
    extends com.android.sdklib.repositoryv2.meta.DetailsTypes.PlatformDetailsType.LayoutlibType
{

    @XmlAttribute(name = "api", required = true)
    protected int api;

    /**
     * Gets the value of the api property.
     * 
     */
    public int getApi() {
        return api;
    }

    /**
     * Sets the value of the api property.
     * 
     */
    public void setApi(int value) {
        this.api = value;
    }

    public ObjectFactory createFactory() {
        return new ObjectFactory();
    }

}
