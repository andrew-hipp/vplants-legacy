//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.10 at 02:44:28 CDT 
//

package org.vplants.utils.jaxb.impl.runtime;


/**
 * Generated classes have to implement this interface for it
 * to be unmarshallable.
 * 
 * @author      Kohsuke KAWAGUCHI
 */
public interface UnmarshallableObject
{
    /**
     * Creates an unmarshaller that will unmarshall this object.
     */
    UnmarshallingEventHandler createUnmarshaller( UnmarshallingContext context );
}