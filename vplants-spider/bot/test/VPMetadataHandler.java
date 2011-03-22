package org.vplants.bot;

import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.util.Vector;

public class VPMetadataHandler extends DefaultHandler {
  private boolean	index = false;
  private boolean	link = false;
  private boolean	taxon = false;
  private boolean state = false;

  private String temp;

  private Vector taxonVector = new Vector();
  private Vector spmVector = new Vector();

  public void startElement(
  	String uri,
   	String local,
   	String qName,
   	Attributes atts
  )
  throws SAXException
  {
   	if ("link".equals(qName)) {
      link = true;
//      if (taxon)
//        System.err.println("START LINK");
    }
    else
   	if ("index".equals(qName))
      index = true;
    else
   	if ("taxon".equals(qName))
      taxon = true;
    else
   	if ("state".equals(qName))
      state = true;
  }

  public void endElement(String uri, String local, String qName)
  throws SAXException
  {
    processNode();

    temp = "";

  	if ("link".equals(qName)) {
      link = false;
//      if (taxon)
//        System.err.println("END LINK");
   	}
    else
  	if ("index".equals(qName)) {
      index = false;
   	}
    else
  	if ("taxon".equals(qName)) {
      taxon = false;
   	}
    else
  	if ("state".equals(qName)) {
      state = false;
   	}
  }

  public void characters(char buf [], int offset, int length)
  throws SAXException
  {
    temp += new String(buf, offset, length);
  }

  private void processNode() {

   	if (link && index) {
      taxonVector.add(temp);
    }
    else
    if (taxon && link) {
      spmVector.add(temp);
   	  System.out.println("SPM: " + temp);
    }
    else
    if (state) {
   	  System.out.print("      ");
   	  System.out.println("STATE: " + temp);
    }
  }

  public Vector getTaxonVector() {
    return taxonVector;
  }

  public Vector getSpmVector() {
    return spmVector;
  }

  public void clearSpmVector() {
    spmVector.clear();
  }
}
