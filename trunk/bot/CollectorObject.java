
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

/**
 * An object for storing collector name information.
 * <P>
 * @author Matthew Schaub
 */
public class CollectorObject extends Object {
/** Collector's first name */
  private String fname = "";
/** Collector's middle name */
  private String mname = "";
/** Collector's last name */
  private String lname = "";

/**
  * Constructor
  * @param fname First Name
  * @param mname Middle Name
  * @param lname Last Name
  */
  public CollectorObject(String fname, String mname, String lname) {
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
  }

/**
  * Default Constructor - initializes all fields to blank.
  */
  public CollectorObject() {
    this("","","");
  }

/**
  * Get the first name.
  * @return String First Name
  */
  public String getFname() {
    return fname;
  }

/**
  * Set the first name.
  * @param temp First Name
  */
  public void setFname(String temp) {
    this.fname = temp;
  }

/**
  * Get the middle name.
  * @return String Middle Name
  */
  public String getMname() {
    return mname;
  }

/**
  * Set the middle name.
  * @param temp Middle Name
  */
  public void setMname(String temp) {
    this.mname = temp;
  }

/**
  * Get the last name.
  * @return String Last Name
  */
  public String getLname() {
    return lname;
  }

/**
  * Set the last name.
  * @param temp Last Name
  */
  public void setLname(String temp) {
    this.lname = temp;
  }

/**
  * Convert the name to a String.
  * @return String First + ' ' + Middle + ' ' + Last
  */
  public String toString() {
    String full = fname + " " + mname + " " + lname;

    return full.trim();
  }

/**
  * Clear all name fields.
  */
  public void clear() {
    fname = "";
    mname = "";
    lname = "";
  }
}
