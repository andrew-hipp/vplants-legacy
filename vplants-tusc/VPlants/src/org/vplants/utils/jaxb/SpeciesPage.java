//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.10 at 02:44:28 CDT 
//


package org.vplants.utils.jaxb;


/**
 * Java content class for speciesPage element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/oracle/jdev1012/jdev/mywork/MortonArboretum/vPlants/src/Ver2b_Sppage.xsd line 17)
 * <p>
 * <pre>
 * &lt;element name="speciesPage">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}NAME_CD"/>
 *           &lt;element ref="{}group"/>
 *           &lt;element ref="{}desc"/>
 *           &lt;element ref="{}similarSpecies"/>
 *           &lt;element ref="{}flowering" minOccurs="0"/>
 *           &lt;element ref="{}fruiting" minOccurs="0"/>
 *           &lt;element ref="{}habitatEcology"/>
 *           &lt;element ref="{}nativity" minOccurs="0"/>
 *           &lt;element ref="{}notes"/>
 *           &lt;element ref="{}etymology"/>
 *           &lt;element ref="{}furtherInfo"/>
 *           &lt;element ref="{}references"/>
 *           &lt;element ref="{}otherRecords"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 */
public interface SpeciesPage
    extends javax.xml.bind.Element, org.vplants.utils.jaxb.SpeciesPageType
{


}
