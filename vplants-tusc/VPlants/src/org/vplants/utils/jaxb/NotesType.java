//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.10 at 02:44:28 CDT 
//


package org.vplants.utils.jaxb;


/**
 * Java content class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/oracle/jdev1012/jdev/mywork/MortonArboretum/vPlants/src/Ver2b_Sppage.xsd line 113)
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}comments" minOccurs="0"/>
 *         &lt;element ref="{}links" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface NotesType {


    /**
     * Gets the value of the links property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.LinksType}
     *     {@link org.vplants.utils.jaxb.Links}
     */
    org.vplants.utils.jaxb.LinksType getLinks();

    /**
     * Sets the value of the links property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.LinksType}
     *     {@link org.vplants.utils.jaxb.Links}
     */
    void setLinks(org.vplants.utils.jaxb.LinksType value);

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getComments();

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setComments(java.lang.String value);

}
