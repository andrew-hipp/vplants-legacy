
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

import java.util.Calendar;
import java.lang.Integer;
import java.text.SimpleDateFormat;
import org.vplants.arch.*;

/**
  * An object for storing specimen summary information stored in the taxon
  * layer.  Information stored in this object includes the specimen id,
  * update dttm, and uri to the specimen's detailed xml page.
  * <P>
  * @author Matthew Schaub
  */
public class SpmHdrObject extends Object {
/** Specimen id */
  private String spmId = "";
/** Month */
  private String month = "";
/** Day */
  private String day = "";
/** Year */
  private String year = "";
/** Hour */
  private String hour = "";
/** Minute */
  private String min = "";
/** URI to the specimen detail */
  private String link = "";

/** Java date object for the update dttm in the xml document */
  private Calendar xmlCal = Calendar.getInstance();
/** Java date object for the update dttm in the database (for the current specimen id) */
  private Calendar dbCal = Calendar.getInstance();

/** Is the specimen in the xml document */
  private boolean inXML = false;
/** Is the specimen in the database */
  private boolean inDB = false;

/** Date format mask for the object */
  SimpleDateFormat updttmFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

/**
  * Default Constructor
  */
  public SpmHdrObject() {
  }

/**
  * Constructor - allows you to set the last update dttm pulled from the database.
  * @param dbUpdttm Database update dttm for the current specimen
  */
  public SpmHdrObject(String dbUpdttm) {
    this();
    setDBUpdttm(dbUpdttm);
  }

/**
  * Get the specimen id.
  * @return String Specimen ID
  */
  public String getSpmId() {
    return spmId;
  }

/**
  * Get the specimen link (uri).
  * @return String Specimen Link (uri)
  */
  public String getLink() {
    return link;
  }

/**
  * Since the pieces for this date arrive in XML chunks, we actually assemble the
  * calendar object as it is requested.
  * @return Calendar Updttm from xml document
  */
  public Calendar getUpdttm() {
    xmlCal.set(Calendar.YEAR, new Integer(year).intValue());
    xmlCal.set(Calendar.MONTH, new Integer(month).intValue() - 1); // month is zero-based!
    xmlCal.set(Calendar.DATE, new Integer(day).intValue());
    xmlCal.set(Calendar.HOUR_OF_DAY, new Integer(hour).intValue());
    xmlCal.set(Calendar.MINUTE, new Integer(min).intValue());
    xmlCal.set(Calendar.SECOND, 0);

    return xmlCal;
  }

/**
  * Get the update dttm from the xml document.
  * @return Calendar Update dttm from xml document
  */
  public Calendar getXMLUpdttm() {
    return this.getUpdttm();
  }

/**
  * Get the update dttm from the xml document in String format.
  * @return String Update dttm from xml document
  */
  public String getXMLUpdttmString() {

    return updttmFormat.format(getXMLUpdttm().getTime());
  }

/**
  * Set a local variable with the database update dttm (YYYYMMDDHHMM).
  * @param dbUpdttm YYYYMMDDHHMM
  */
  public void setDBUpdttm(String dbUpdttm) {
    if (dbUpdttm.length() > 0) {

      inDB = true;

      dbCal.set(Calendar.YEAR, new Integer(dbUpdttm.substring(0,4)).intValue());
      dbCal.set(Calendar.MONTH, new Integer(dbUpdttm.substring(4,6)).intValue() - 1); // month is zero-based!
      dbCal.set(Calendar.DATE, new Integer(dbUpdttm.substring(6,8)).intValue());
      dbCal.set(Calendar.HOUR_OF_DAY, new Integer(dbUpdttm.substring(8,10)).intValue());
      dbCal.set(Calendar.MINUTE, new Integer(dbUpdttm.substring(10,12)).intValue());
      dbCal.set(Calendar.SECOND, 0);
    }
  }

/**
  * Get the update dttm from the database.
  * @return Calendar Update dttm from the database
  */
  public Calendar getDBUpdttm() {
    return dbCal;
  }

/**
  * Get the update dttm from the database in String format.
  * @return String Update dttm from database.
  */
  public String getDBUpdttmString() {

    return updttmFormat.format(getDBUpdttm().getTime());
  }

/**
  * Set the specimen id.
  * @param spmId Specimen id
  */
  public void setSpmId(String spmId) {
    this.spmId = spmId;
  }

/**
  * Set the specimen link (uri).
  * @param link Specimen link
  */
  public void setLink(String link) {
    inXML = true;
    this.link = link;
  }

/**
  * Set the update month.
  * @param month Month
  */
  public void setMonth(String month) {
    this.month = month;
  }

/**
  * Set the update day.
  * @param day Day
  */
  public void setDay(String day) {
    this.day = day;
  }

/**
  * Set the update year.
  * @param year Year
  */
  public void setYear(String year) {
    this.year = year;
  }

/**
  * Set the update hour.
  * @param hour Hour
  */
  public void setHour(String hour) {
    this.hour = hour;
  }

/**
  * Set the update month.
  * @param month Month
  */
  public void setMin(String min) {
    this.min = min;
  }

/**
  * Is the object empty? T/F
  * @return boolean Empty? T/F
  */
  public boolean isEmpty() {
    if (link.length() == 0)
      return true;
    else
      return false;
  }

/**
  * Clear all local variables.
  */
  public void clear() {
    spmId = "";
    month = "";
    day = "";
    year = "";
    hour = "";
    min = "";
    link = "";
    xmlCal.clear();
    dbCal.clear();
  }

/**
  * Is the current specimen in the xml document?
  * @return boolean In XML? T/F
  */
  public boolean isInXML() {
    return inXML;
  }

/**
  * Is the current specimen in the database?
  * @return boolean In database? T/F
  */
  public boolean isInDB() {
    return inDB;
  }

/**
  * Should this specimen be inserted into the database?  If it's in the xml
  * document but not in the database then yes, it's an insert.
  * @return boolean Is this an insert? T/F
  */
  public boolean isInsert() {
    // if it's not in the database, do an insert
    if (!isInDB() && isInXML())
      return true;
    else
      return false;
  }

/**
  * Should this specimen be updated in the database?  If the xml update dttm is
  * greater than the dttm stored in the database then yes, the data in the xml
  * document has changed since our last visit so lets perform an update.
  * @return boolean Is this an update? T/F
  */
  public boolean isUpdate() {
    String xmlDate = this.getXMLUpdttmString();
    String dbDate = this.getDBUpdttmString();
    Log.log(Log.LOG_LEVEL_DUMP, "[" + xmlDate + "] x [" + dbDate + "]");
    if (getXMLUpdttm().after(getDBUpdttm()))
      return true;
    else
      return false;
  }
}
