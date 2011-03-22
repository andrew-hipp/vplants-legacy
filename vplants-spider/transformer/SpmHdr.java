package org.vplants.transformer;

import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * This class represents a single specimen header record.  A given name_cd
 * will have 1 to many specimen header records, each representing a unique
 * specimen by it's specimen id and update date/time.
 * <P>
 * @author Matthew Schaub
 */
public class SpmHdr extends Object {

  private String spmid;
  private String month;
  private String day;
  private String year;
  private String hour;
  private String min;

  /**
   * Constructor
   */
  public SpmHdr() {
    super();
  }

/** Clears all data fields in the object */
  public void clear() {
    spmid = null;
    month = null;
    day = null;
    year = null;
    hour = null;
    min = null;
  }

  public String toString() {
    return this.spmid;
  }

/*****************/

  public void setSpmid(String spmid) {
    this.spmid = spmid;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public void setMin(String min) {
    this.min = min;
  }

/*****************/

  public String getSpmid() {
    return spmid;
  }

  public String getMonth() {
    return month;
  }

  public String getDay() {
    return day;
  }

  public String getYear() {
    return year;
  }

  public String getHour() {
    return hour;
  }

  public String getMin() {
    return min;
  }

/** Returns an Element model for the specimen header record.
  * @return Element representation of the header record.
  */
  public Element getElement() {
    Element root = new Element("SPM_HDR");

    Element spmidE = new Element("SPM_ID");
    spmidE.addContent(this.getSpmid());

    Element monthE = new Element("MONTH");
    monthE.addContent(this.getMonth());

    Element dayE = new Element("DAY");
    dayE.addContent(this.getDay());

    Element yearE = new Element("YEAR");
    yearE.addContent(this.getYear());

    Element hourE = new Element("HOUR");
    hourE.addContent(this.getHour());

    Element minE = new Element("MIN");
    minE.addContent(this.getMin());

    root.addContent(spmidE);
    root.addContent(monthE);
    root.addContent(dayE);
    root.addContent(yearE);
    root.addContent(hourE);
    root.addContent(minE);

    return root;
  }

}

