package org.vplants.bot;

import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.vplants.arch.*;

/**
  * Sax handler object for the vPlants Metadata Specimen Layer.  This layer contains
  * specimen level details for a single specimen.
  * <P>
  * The SpmHandler parses a specimen XML page, packaging the information into a
  * java object for further processing.
  * <P>
  * @author Matthew Schaub
  */
public class SpmHandler extends AbstractHandler {
/** Are we in a specimen object? */
  private boolean spm = false;

/** Are we in a collected date object? */
  private boolean colldate = false;
/** Are we in a month object? */
  private boolean month = false;
/** Are we in a day object? */
  private boolean day = false;
/** Are we in a year object? */
  private boolean year = false;

/** Are we in a primary collector object? */
  private boolean pcoll = false;
/** Are we in a secondary collector object? */
  private boolean scoll = false;
/** Are we in a last name object? */
  private boolean lname = false;
/** Are we in a middle name object? */
  private boolean mname = false;
/** Are we in a first name object? */
  private boolean fname = false;

/** Are we in a collector number object? */
  private boolean collnbr = false;

/** Are we in a site geography object? */
  private boolean sitegeo = false;
/** Are we in a state object? */
  private boolean	state = false;
/** Are we in a county object? */
  private boolean	county = false;
/** Are we in a city object? */
  private boolean	city = false;
/** Are we in a township object? */
  private boolean	township = false;

/** Are we in a site survey object? */
  private boolean sitesurvey = false;
/** Are we in a township object? */
  private boolean twpnum = false;
/** Are we in a township direction object? */
  private boolean twpdir = false;
/** Are we in a range object? */
  private boolean rngnum = false;
/** Are we in a range direction object? */
  private boolean rngdir = false;
/** Are we in a section object? */
  private boolean secnum = false;
/** Are we in a section detail object? */
  private boolean secdtl = false;

/** Are we in a site GPS object? */
  private boolean sitegps = false;
/** Are we in a lat. direction object? */
  private boolean latdir = false;
/** Are we in a lat. decimal degrees object? */
  private boolean latdd = false;
/** Are we in a long. direction object? */
  private boolean longdir = false;
/** Are we in a long. decimal degrees object? */
  private boolean longdd = false;

/** Are we in a locality object? */
  private boolean locality = false;
/** Are we in a habitat object? */
  private boolean habitat = false;

/** Are we in a homepage object? */
  private boolean homepg = false;
/** Are we in a link object? */
  private boolean link = false;
/** Are we in a image object? */
  private boolean image = false;

/** Are we in a create date object? */
  private boolean crdate = false;

/** Specimen information java object */
  private SpmObject spmObject;
/** Collector information java object */
  private CollectorObject currentCollector;
/** Image java object */
  private ImageObject currentImage;

/**
  * Constructor.
  */
  public SpmHandler() {
    super();

    spmObject = new SpmObject();
  }

/**
  * Override the super method to catch the beginning the following tags:
  * spm - triggering the clearing of the specimen object
  * pcoll/scoll - triggering the clearing of the collector object
  * typespm - simply set the type specimen boolean to true
  * any homepg more information tag - grab the attribute and set the specimen object
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

    if ("spm".equals(qName))
      spmObject.clear();
    else if (("pcoll".equals(qName)) ||
             ("scoll".equals(qName)))
      currentCollector = new CollectorObject();
    else if ("typespm".equals(qName))
      spmObject.setTypeSpm(true);
    else if (homepg) {
      if ("loc".equals(qName))
        spmObject.setHpLoc(atts.getValue("data"));
      else if ("hab".equals(qName))
        spmObject.setHpHab(atts.getValue("data"));
      else if ("desc".equals(qName))
        spmObject.setHpDesc(atts.getValue("data"));
      else if ("assoc".equals(qName))
        spmObject.setHpAssoc(atts.getValue("data"));
      else if ("annot".equals(qName))
        spmObject.setHpAnnot(atts.getValue("data"));
      else if ("image".equals(qName)) {
        currentImage = new ImageObject();
        currentImage.setType(atts.getValue("type"));
      }
    }
  }

/**
  * Override the super method to catch the ending the following tags:
  * pcoll/scoll - add the collector to the specimen object
  * image - add the image to the specimen object
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

    if ("pcoll".equals(qName))
      spmObject.setPColl(currentCollector);
    else if ("scoll".equals(qName))
      spmObject.addSColl(currentCollector);
    else if ("image".equals(qName))
      spmObject.addImage(currentImage);
  }

/**
  * For every element processed by the sax parser, a boolean variable corresponding
  * to the element name is set (true at the start tag, false at the end tag).  This
  * lets us know where we are at in the xml document, allowing for element-specific processing.
  * @param qName Current tag name
  * @param flag Boolean value
  */
  public void setFlag(String qName, boolean flag) {
   	if ("spm".equals(qName))
      spm = flag;
    else if ("colldate".equals(qName))
      colldate = flag;
    else if ("month".equals(qName))
      month = flag;
    else if ("day".equals(qName))
      day = flag;
    else if ("year".equals(qName))
      year = flag;
    else if ("collnbr".equals(qName))
      collnbr = flag;
    else if ("pcoll".equals(qName))
      pcoll = flag;
    else if ("scoll".equals(qName))
      scoll = flag;
    else if ("lname".equals(qName))
      lname = flag;
    else if ("mname".equals(qName))
      mname = flag;
    else if ("fname".equals(qName))
      fname = flag;
   	else if ("sitegeo".equals(qName))
      sitegeo = flag;
   	else if ("state".equals(qName))
      state = flag;
   	else if ("county".equals(qName))
      county = flag;
   	else if ("city".equals(qName))
      city = flag;
   	else if ("township".equals(qName))
      township = flag;
   	else if ("sitesurvey".equals(qName))
      sitesurvey = flag;
   	else if ("twpnum".equals(qName))
      twpnum = flag;
   	else if ("twpdir".equals(qName))
      twpdir = flag;
   	else if ("rngnum".equals(qName))
      rngnum = flag;
   	else if ("rngdir".equals(qName))
      rngdir = flag;
   	else if ("secnum".equals(qName))
      secnum = flag;
   	else if ("secdtl".equals(qName))
      secdtl = flag;
   	else if ("sitegps".equals(qName))
      sitegps = flag;
   	else if ("latdir".equals(qName))
      latdir = flag;
   	else if ("latdd".equals(qName))
      latdd = flag;
   	else if ("longdir".equals(qName))
      longdir = flag;
   	else if ("longdd".equals(qName))
      longdd = flag;
   	else if ("locality".equals(qName))
      locality = flag;
   	else if ("habitat".equals(qName))
      habitat = flag;
   	else if ("homepg".equals(qName))
      homepg = flag;
   	else if ("link".equals(qName))
      link = flag;
   	else if ("image".equals(qName))
      image = flag;
   	else if ("crdate".equals(qName))
      crdate = flag;
  }

/**
  * Depending on what tag we are currently processing (check the tag booleans),
  * perform the necessary packaging functionality (place the data into the
  * specimen object).
  * @param temp Current nodes value
  */
  public void processNode(String temp) {

   	if (colldate) {
      if (month)
        spmObject.setCollMonth(temp);
      else if (day)
        spmObject.setCollDay(temp);
      else if (year)
        spmObject.setCollYear(temp);
    }
    else if (pcoll || scoll) {
      if (lname)
        currentCollector.setLname(temp);
      else if (mname)
        currentCollector.setMname(temp);
      else if (fname)
        currentCollector.setFname(temp);
    }
    else if (collnbr) {
      spmObject.setCollNbr(temp);
    }
    else if (sitegeo) {
      if (state)
        spmObject.setState(temp);
      else if (county)
        spmObject.setCounty(temp);
      else if (city)
        spmObject.setCity(temp);
      else if (township)
        spmObject.setTownship(temp);
    }
    else if (sitesurvey) {
      if (twpnum)
        spmObject.setTwpNum(temp);
      else if (twpdir)
        spmObject.setTwpDir(temp);
      else if (rngnum)
        spmObject.setRngNum(temp);
      else if (rngdir)
        spmObject.setRngDir(temp);
      else if (secnum)
        spmObject.setSecNum(temp);
      else if (secdtl)
        spmObject.setSecDtl(temp);
    }
    else if (sitegps) {
      if (latdir)
        spmObject.setLatDir(temp);
      else if (latdd)
        spmObject.setLatDD(temp);
      else if (longdir)
        spmObject.setLongDir(temp);
      else if (longdd)
        spmObject.setLongDD(temp);
    }
    else if (locality) {
      spmObject.setLocality(temp);
    }
    else if (habitat) {
      spmObject.setHabitat(temp);
    }
    else if (homepg) {
      if (link)
        spmObject.setHpURI(temp);
      else if (image)
        this.currentImage.setURI(temp);
    }
   	else if (crdate) {
      if (month)
        spmObject.setCrMonth(temp);
      else if (day)
        spmObject.setCrDay(temp);
      else if (year)
        spmObject.setCrYear(temp);
    }

  }

/**
  * Return a reference to the specimen object.
  * @return SpmObject Current specimen object
  */
  public SpmObject getSpmObject() {
    return spmObject;
  }

/**
  * Clear all booleans in the object.
  */
  public void clearFlags() {
    spm = false;
    colldate = false;
    month = false;
    day = false;
    year = false;
    pcoll = false;
    scoll = false;
    lname = false;
    mname = false;
    fname = false;
    collnbr = false;
    sitegeo = false;
    state = false;
    county = false;
    city = false;
    township = false;
    sitesurvey = false;
    twpnum = false;
    twpdir = false;
    rngnum = false;
    rngdir = false;
    secnum = false;
    secdtl = false;
    sitegps = false;
    latdir = false;
    latdd = false;
    longdir = false;
    longdd = false;
    locality = false;
    habitat = false;
    homepg = false;
    link = false;
    image = false;
    crdate = false;
  }
}
