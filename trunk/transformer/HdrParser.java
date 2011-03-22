
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.transformer;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
/**
 * This class encompasses the Sax parser components used to dissect the
 * header information.  Both a producer and consumer are created to drive
 * the process.
 * <P>
 * @author Matthew Schaub
 */
public class HdrParser extends Object {
  XMLReader   producer;
  HdrHandler  consumer;

  /**
   * Constructor method, looking for the output destination directory, the
   * URI base where the XML documents will be published, and a visible TextField
   * used to reflect the programs status.
   */
  public HdrParser(String outPath, String uriBase, JTextField status)
  throws SAXException, javax.xml.transform.TransformerConfigurationException {

    consumer = new HdrHandler(outPath, uriBase, status);

    // Get an instance of the default XML parser class
    producer = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");

    producer.setFeature( "http://xml.org/sax/features/validation",
                                             false);

    producer.setFeature( "http://xml.org/sax/features/namespaces",
                                             false);

    producer.setFeature( "http://apache.org/xml/features/validation/schema",
                                             false);

    producer.setFeature( "http://apache.org/xml/features/validation/schema-full-checking",
                                             false);

    // Connect the most important standard handler
    producer.setContentHandler(consumer);

    // Arrange error handling
    producer.setErrorHandler(consumer);
  }

/** Triggers the parser to process the current line from the CSV file - this line
  * has already been converted into the blueprint format. */
  public void parse(String line)
  throws IOException, SAXException {
    try {
      consumer.clearFlags();
      producer.parse(new InputSource(new java.io.StringReader(line)));
    } catch (SAXException se) {
      consumer.clearBuffer();
      throw se;
    } catch (IOException ie) {
      consumer.clearBuffer();
      throw ie;
    }
  }

/** Supplies all name_cds processed by the parser - used to build the index.xml file.
  * @return Vector containing all name_cds processed
  */
  public Vector getNameCdVector() {
    return consumer.getNameCdVector();
  }

/** Supplies the current name_cd.
  * @return String representation of the current name_cd
  */
  public String getCurrNameCd() {
    return consumer.getCurrNameCd();
  }

/** Supplies the current specimen id.
  * @return String representation of the current specimen id.
  */
  public String getCurrSpmId() {
    return consumer.getCurrSpmId();
  }

/** Triggers the consumer object to create a taxon level xml document.
  */
  public void closeoutSpmHdr() {
    consumer.closeoutSpmHdr();
  }
}

