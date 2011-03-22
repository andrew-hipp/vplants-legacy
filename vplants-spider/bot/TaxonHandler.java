package org.vplants.bot;

import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.vplants.arch.*;

/**
  * Sax handler object for the vPlants Metadata Taxon Layer.  This layer contains
  * taxon level details including a listing of the specimen for the taxon and
  * their last update date-timestamp.
  * <P>
  * The TaxonHandler parses a taxon XML page, packaging the information into a
  * java object for further processing.
  * <P>
  * @author Matthew Schaub
  */
public class TaxonHandler extends AbstractHandler {
/** Are we in a taxon tag? */
  private boolean taxon = false;
/** Are we in a namecode tag? */
  private boolean namecode = false;
/** Are we in a common tag? */
  private boolean common = false;
/** Are we in a spm tag? */
  private boolean spm = false;
/** Are we in a spmid tag? */
  private boolean spmid = false;
/** Are we in a updttm tag? */
  private boolean updttm = false;
/** Are we in a month tag? */
  private boolean month = false;
/** Are we in a day tag? */
  private boolean day = false;
/** Are we in a year tag? */
  private boolean year = false;
/** Are we in a hour tag? */
  private boolean hour = false;
/** Are we in a min tag? */
  private boolean min = false;
/** Are we in a link tag? */
  private boolean	link = false;

/** Java object for a taxon page */
  private TaxonObject taxonObject;
/** Specimen header object for a single specimen record */
  private SpmHdrObject spmHdrObject;

/** Default Constructor - initializes a taxon object */
  public TaxonHandler() {
    super();

    taxonObject = new TaxonObject();
  }

/**
  * Override startElement to catch when taxon and spm tags begin.
  * @param uri Namespace uri
  * @param local Local name
  * @param qName Qualified name (xml element tag name)
  * @param atts Attributes attached to the element
  */
  public void startElement(
  	String uri,
   	String local,
   	String qName,
   	Attributes atts
  )
  throws SAXException
  {
    super.startElement(uri, local, qName, atts);

    if ("taxon".equals(qName)) {
      taxonObject.clear();
    }
    else if ("spm".equals(qName)) {
      spmHdrObject = new SpmHdrObject();
    }
  }

/**
  * Override the super method to catch the ending of a spm tag - the specimen
  * header object is then stacked into the taxon object for later processing.
  * @param uri Namespace uri
  * @param local Local name
  * @param qName Qualified name (xml element tag name)
  */

  public void endElement(
  	String uri,
   	String local,
   	String qName
  )
  throws SAXException
  {
    super.endElement(uri, local, qName);

    if ("spm".equals(qName)) {
      taxonObject.addSpmHdrObject(spmHdrObject);
    }
  }

/**
  * For every element processed by the sax parser, a boolean variable corresponding
  * to the element name is set (true at the start tag, false at the end tag).  This
  * lets us know where we are at in the xml document, allowing for element-specific processing.
  * @param qName Current tag name
  * @param flag Boolean value
  */
  public void setFlag(String qName, boolean flag) {
   	if ("taxon".equals(qName))
      taxon = flag;
   	else if ("namecd".equals(qName))
      namecode = flag;
   	else if ("common".equals(qName))
      common = flag;
   	else if ("spm".equals(qName))
      spm = flag;
    else if ("spmid".equals(qName))
      spmid = flag;
   	else if ("updttm".equals(qName))
      updttm = flag;
   	else if ("month".equals(qName))
      month = flag;
   	else if ("day".equals(qName))
      day = flag;
   	else if ("year".equals(qName))
      year = flag;
   	else if ("hour".equals(qName))
      hour = flag;
   	else if ("min".equals(qName))
      min = flag;
   	else if ("link".equals(qName))
      link = flag;
  }

/**
  * Depending on what tag we are currently processing (check the tag booleans),
  * perform the necessary packaging functionality (place the data into the
  * specimen object).
  * @param temp Current nodes value
  */
  public void processNode(String temp) {
    if (namecode) {
      taxonObject.setNameCode(temp);
    }
    else if (common) {
      taxonObject.addCommonName(temp);
    }
    else if (spm && spmid) {
      spmHdrObject.setSpmId(temp);
    }
    else if (spm && link) {
      spmHdrObject.setLink(temp);
    }
    else if (spm && updttm && month) {
      spmHdrObject.setMonth(temp);
    }
    else if (spm && updttm && day) {
      spmHdrObject.setDay(temp);
    }
    else if (spm && updttm && year) {
      spmHdrObject.setYear(temp);
    }
    else if (spm && updttm && hour) {
      spmHdrObject.setHour(temp);
    }
    else if (spm && updttm && min) {
      spmHdrObject.setMin(temp);
    }

  }

/**
  * Return a reference to the taxon object.
  * @return TaxonObject Taxon object
  */
  public TaxonObject getTaxonObject() {
    return taxonObject;
  }

/**
  * Clear all booleans in the object.
  */
  public void clearFlags() {
    taxon = false;
    namecode = false;
    common = false;
    spm = false;
    spmid = false;
    updttm = false;
    month = false;
    day = false;
    year = false;
    hour = false;
    min = false;
    link = false;
  }
}
