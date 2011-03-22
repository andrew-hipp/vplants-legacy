
// Copyright (c) 2000 The Morton Arboretum
package org.vplants;

import org.jdom.Document;
import org.jdom.Element;

/**
 * A Bean class.
 * <P>
 * @author Matthew Schaub
 */
public class Specimen extends Object {

  private String spmid;
  private String lname;
  private String fname;

  Element rootE;
  Element spmidE;
  Element lnameE;
  Element fnameE;
  Document outdoc;

  /**
   * Constructor
   */
  public Specimen() {
    super();
  }

  public void clear() {
    spmid = null;
    lname = null;
    fname = null;
  }

  public String toString() {
    return this.spmid;
  }

  public Document getXMLDocument() {
      rootE = new Element("spmdtl");
      outdoc = new Document(rootE);

      spmidE = new Element("spm_id");
      spmidE.addContent(getSpmid());
      rootE.addContent(spmidE);

      lnameE = new Element("l_name");
      lnameE.addContent(getLname());
      rootE.addContent(lnameE);

      fnameE = new Element("f_name");
      fnameE.addContent(getFname());
      rootE.addContent(fnameE);

      return outdoc;
  }

  public void setSpmid(String spmid) {
    this.spmid = spmid;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getSpmid() {
    return spmid;
  }

  public String getLname() {
    return lname;
  }

  public String getFname() {
    return fname;
  }
}

