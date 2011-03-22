
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.*;
import org.vplants.arch.*;

/**
 * A class representing the sax producter/consumer model.
 * <P>
 * @author Matthew Schaub
 */
public class XMLPipeline extends Object
{

/** sax xml producer object - creates sax events while parsing xml documents */
  XMLReader       producer;
/** sax xml consumer object - consumes and processes sax events from the producer */
  DefaultHandler  consumer;

/**
  * Constructor
  * @param setValidation Should we validate the xml document?
  * @param setNameSpaces Should we support namespaces?
  * @param setSchemaSupport Should we support schemas?
  * @param setSchemaFullSupport Should we support full schemas?
  * @param consumer Sax consumer object
  * @param className Parser class name
  */
  public XMLPipeline(
    boolean setValidation, boolean setNameSpaces,
    boolean setSchemaSupport, boolean setSchemaFullSupport,
    DefaultHandler consumer, String className
  )
  throws SAXException {

    // Get an instance of the default XML parser class
    producer = XMLReaderFactory.createXMLReader(className);

    producer.setFeature( "http://xml.org/sax/features/validation",
                                             setValidation);

    producer.setFeature( "http://xml.org/sax/features/namespaces",
                                             setNameSpaces );

    producer.setFeature( "http://apache.org/xml/features/validation/schema",
                                             setSchemaSupport );

    producer.setFeature( "http://apache.org/xml/features/validation/schema-full-checking",
                                             setSchemaFullSupport );

    // Get a consumer for all the parser events
    this.consumer = consumer;

    // Connect the most important standard handler
    producer.setContentHandler(this.consumer);

    // Arrange error handling
    producer.setErrorHandler(this.consumer);
  }

/**
  * Constructor - sets all features to true and uses the xerces sax parser.
  * @param consumer Sax consumer object
  */
  public XMLPipeline(DefaultHandler consumer)
  throws SAXException {
    this(true, true, true, true,
        consumer,
        "org.apache.xerces.parsers.SAXParser"
    );
  }

/**
  * Default Constructor - sets all features to true and uses the xerces sax parser.
  * The consumer class is set to null.
  */
  public XMLPipeline()
  throws SAXException {
    this(true, true, true, true,
        null,
        "org.apache.xerces.parsers.SAXParser"
    );
  }

/**
  * Parse the given xml document (by uri).
  * @param systemId URI for xml document to be parsed.
  */
  public void parse(String systemId)
  throws SAXException, IOException {
    try {
      ((AbstractHandler)consumer).clearFlags(); // reset all tag flags to false
      producer.parse(systemId);
    } finally {
      ((AbstractHandler)consumer).clearBuffer();
    }
  }
}
