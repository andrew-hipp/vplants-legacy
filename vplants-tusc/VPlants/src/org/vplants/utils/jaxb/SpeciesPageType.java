//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.10 at 02:44:28 CDT 
//


package org.vplants.utils.jaxb;


/**
 * Java content class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/oracle/jdev1012/jdev/mywork/MortonArboretum/vPlants/src/Ver2b_Sppage.xsd line 18)
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}NAME_CD"/>
 *         &lt;element ref="{}group"/>
 *         &lt;element ref="{}desc"/>
 *         &lt;element ref="{}similarSpecies"/>
 *         &lt;element ref="{}flowering" minOccurs="0"/>
 *         &lt;element ref="{}fruiting" minOccurs="0"/>
 *         &lt;element ref="{}habitatEcology"/>
 *         &lt;element ref="{}nativity" minOccurs="0"/>
 *         &lt;element ref="{}notes"/>
 *         &lt;element ref="{}etymology"/>
 *         &lt;element ref="{}furtherInfo"/>
 *         &lt;element ref="{}references"/>
 *         &lt;element ref="{}otherRecords"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface SpeciesPageType {


    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.Notes}
     *     {@link org.vplants.utils.jaxb.NotesType}
     */
    org.vplants.utils.jaxb.NotesType getNotes();

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.Notes}
     *     {@link org.vplants.utils.jaxb.NotesType}
     */
    void setNotes(org.vplants.utils.jaxb.NotesType value);

    /**
     * Gets the value of the namecd property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getNAMECD();

    /**
     * Sets the value of the namecd property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setNAMECD(java.lang.String value);

    /**
     * Gets the value of the flowering property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getFlowering();

    /**
     * Sets the value of the flowering property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setFlowering(java.lang.String value);

    /**
     * Gets the value of the fruiting property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getFruiting();

    /**
     * Sets the value of the fruiting property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setFruiting(java.lang.String value);

    /**
     * Gets the value of the similarSpecies property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.SimilarSpeciesType}
     *     {@link org.vplants.utils.jaxb.SimilarSpecies}
     */
    org.vplants.utils.jaxb.SimilarSpeciesType getSimilarSpecies();

    /**
     * Sets the value of the similarSpecies property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.SimilarSpeciesType}
     *     {@link org.vplants.utils.jaxb.SimilarSpecies}
     */
    void setSimilarSpecies(org.vplants.utils.jaxb.SimilarSpeciesType value);

    /**
     * Gets the value of the references property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.References}
     *     {@link org.vplants.utils.jaxb.ReferencesType}
     */
    org.vplants.utils.jaxb.ReferencesType getReferences();

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.References}
     *     {@link org.vplants.utils.jaxb.ReferencesType}
     */
    void setReferences(org.vplants.utils.jaxb.ReferencesType value);

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getGroup();

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setGroup(java.lang.String value);

    /**
     * Gets the value of the habitatEcology property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getHabitatEcology();

    /**
     * Sets the value of the habitatEcology property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setHabitatEcology(java.lang.String value);

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.Desc}
     *     {@link org.vplants.utils.jaxb.DescType}
     */
    org.vplants.utils.jaxb.DescType getDesc();

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.Desc}
     *     {@link org.vplants.utils.jaxb.DescType}
     */
    void setDesc(org.vplants.utils.jaxb.DescType value);

    /**
     * Gets the value of the etymology property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.Etymology}
     *     {@link org.vplants.utils.jaxb.EtymologyType}
     */
    org.vplants.utils.jaxb.EtymologyType getEtymology();

    /**
     * Sets the value of the etymology property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.Etymology}
     *     {@link org.vplants.utils.jaxb.EtymologyType}
     */
    void setEtymology(org.vplants.utils.jaxb.EtymologyType value);

    /**
     * Gets the value of the otherRecords property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.OtherRecordsType}
     *     {@link org.vplants.utils.jaxb.OtherRecords}
     */
    org.vplants.utils.jaxb.OtherRecordsType getOtherRecords();

    /**
     * Sets the value of the otherRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.OtherRecordsType}
     *     {@link org.vplants.utils.jaxb.OtherRecords}
     */
    void setOtherRecords(org.vplants.utils.jaxb.OtherRecordsType value);

    /**
     * Gets the value of the furtherInfo property.
     * 
     * @return
     *     possible object is
     *     {@link org.vplants.utils.jaxb.FurtherInfo}
     *     {@link org.vplants.utils.jaxb.FurtherInfoType}
     */
    org.vplants.utils.jaxb.FurtherInfoType getFurtherInfo();

    /**
     * Sets the value of the furtherInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.vplants.utils.jaxb.FurtherInfo}
     *     {@link org.vplants.utils.jaxb.FurtherInfoType}
     */
    void setFurtherInfo(org.vplants.utils.jaxb.FurtherInfoType value);

    /**
     * Gets the value of the nativity property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getNativity();

    /**
     * Sets the value of the nativity property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setNativity(java.lang.String value);

}