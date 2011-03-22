
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

import java.util.Calendar;
import java.util.Vector;
import java.lang.Integer;
import org.vplants.arch.*;

/**
 * An object for storing specimen level information.
 * <P>
 * @author Matthew Schaub
 */
public class SpmObject extends Object {

  private DateObject collDate = new DateObject();

  private CollectorObject pcoll = null;
  private Vector scoll = new Vector();

  private String collnbr = "";

  private String state = "";
  private String county = "";
  private String township = "";
  private String city = "";

  private String twpnum = "";
  private String twpdir = "";
  private String rngnum = "";
  private String rngdir = "";
  private String secnum = "";
  private String secdtl = "";

  private String latdir = "";
  private String latdd = "";
  private String longdir = "";
  private String longdd = "";

  private String locality = "";
  private String habitat = "";
  private boolean typespm = false;

  private String hpuri = "";
  private String hploc = "N";
  private String hphab = "N";
  private String hpdesc = "N";
  private String hpassoc = "N";
  private String hpannot = "N";
  private Vector images = new Vector();

  private DateObject crDate = new DateObject();
  private String crmonth = "";
  private String crday = "";
  private String cryear = "";

/**
  * Constructor
  */
  public SpmObject() {
    super();
  }

/**********SET***********/

  public void setCollMonth(String temp) {
    collDate.setMonth(temp);
  }

  public void setCollDay(String temp) {
    collDate.setDay(temp);
  }

  public void setCollYear(String temp) {
    collDate.setYear(temp);
  }

  public void setPColl(CollectorObject temp) {
    this.pcoll = temp;
  }

  public void addSColl(CollectorObject temp) {
    this.scoll.add(temp);
  }

  public void setCollNbr(String temp) {
    this.collnbr = temp;
  }

  public void setState(String temp) {
    this.state = temp;
  }

  public void setCounty(String temp) {
    this.county = temp;
  }

  public void setCity(String temp) {
    this.city = temp;
  }

  public void setTownship(String temp) {
    this.township = temp;
  }

  public void setTwpNum(String temp) {
    this.twpnum = temp;
  }

  public void setTwpDir(String temp) {
    this.twpdir = temp;
  }

  public void setRngNum(String temp) {
    this.rngnum = temp;
  }

  public void setRngDir(String temp) {
    this.rngdir = temp;
  }

  public void setSecNum(String temp) {
    this.secnum = temp;
  }

  public void setSecDtl(String temp) {
    this.secdtl = temp;
  }

  public void setLatDir(String temp) {
    this.latdir = temp;
  }

  public void setLatDD(String temp) {
    this.latdd = temp;
  }

  public void setLongDir(String temp) {
    this.longdir = temp;
  }

  public void setLongDD(String temp) {
    this.longdd = temp;
  }

  public void setLocality(String temp) {
    this.locality = temp;
  }

  public void setHabitat(String temp) {
    this.habitat = temp;
  }

  public void setTypeSpm(boolean temp) {
    this.typespm = temp;
  }

  public void setCrMonth(String temp) {
    crDate.setMonth(temp);
  }

  public void setCrDay(String temp) {
    crDate.setDay(temp);
  }

  public void setHpURI(String temp) {
    this.hpuri = temp;
  }

  public void setHpLoc(String temp) {
    this.hploc = temp;
  }

  public void setHpHab(String temp) {
    this.hphab = temp;
  }

  public void setHpDesc(String temp) {
    this.hpdesc = temp;
  }

  public void setHpAssoc(String temp) {
    this.hpassoc = temp;
  }

  public void setHpAnnot(String temp) {
    this.hpannot = temp;
  }

  public void addImage(ImageObject temp) {
    images.add(temp);
  }

  public void setCrYear(String temp) {
    crDate.setYear(temp);
  }

/**********GET***********/

  public String getCollDate() {
    return collDate.getDate();
  }

  public int getCollDateMask() {
    return collDate.getMask();
  }

  public String getCollNbr() {
    return collnbr;
  }

  public CollectorObject getPColl() {
    return pcoll;
  }

  public Vector getSColl() {
    return scoll;
  }

  public String getState() {
    return this.state;
  }

  public String getCounty() {
    return this.county;
  }

  public String getCity() {
    return this.city;
  }

  public String getTownship() {
    return this.township;
  }

  public String getTwpNum() {
    return this.twpnum;
  }

  public String getTwpDir() {
    return this.twpdir;
  }

  public String getRngNum() {
    return this.rngnum;
  }

  public String getRngDir() {
    return this.rngdir;
  }

  public String getSecNum() {
    return this.secnum;
  }

  public String getSecDtl() {
    return this.secdtl;
  }

  public String getLatDir() {
    return this.latdir;
  }

  public String getLatDD() {
    return this.latdd;
  }

  public String getLongDir() {
    return this.longdir;
  }

  public String getLongDD() {
    return this.longdd;
  }

  public String getLocality() {
    return this.locality;
  }

  public String getHabitat() {
    return this.habitat;
  }

  public boolean isTypeSpm() {
    return this.typespm;
  }

  public String getHpURI() {
    return this.hpuri;
  }

  public String getHpLoc() {
    return this.hploc;
  }

  public String getHpHab() {
    return this.hphab;
  }

  public String getHpDesc() {
    return this.hpdesc;
  }

  public String getHpAssoc() {
    return this.hpassoc;
  }

  public String getHpAnnot() {
    return this.hpannot;
  }

  public Vector getImages() {
    return this.images;
  }

  public String getCrDate() {
    return crDate.getDate();
  }

/**************HAS****************/

  public boolean hasPrimaryColl() {
    if ((pcoll != null) && (pcoll.getLname().length() > 0))
      return true;
    else
      return false;
  }

  public boolean hasLocality() {
    if (locality.length() > 0)
      return true;
    else
      return false;
  }

  public boolean hasHabitat() {
    if (habitat.length() > 0)
      return true;
    else
      return false;
  }

  public boolean hasSiteGeo() {
    if (state.length() > 0)
      return true;
    else
      return false;
  }

  public boolean hasSiteGlobal() {
    if (latdd.length() > 0)
      return true;
    else
      return false;
  }

  public boolean hasSiteSurvey() {
    if (twpnum.length() > 0)
      return true;
    else
      return false;
  }

  public boolean hasSpmPage() {
    if (
        (hpuri.length() > 0) ||
        (
         (!hploc.equals("N")) ||
         (!hphab.equals("N")) ||
         (!hpdesc.equals("N")) ||
         (!hpassoc.equals("N")) ||
         (!hpannot.equals("N"))
         )
        )
      return true;
    else
      return false;
  }

/*********************************/

  public void clear() {
    this.collDate.clear();
    this.pcoll = null;
    this.scoll.removeAllElements();
    this.collnbr = "";
    this.state = "";
    this.county = "";
    this.township = "";
    this.city = "";
    this.twpnum = "";
    this.twpdir = "";
    this.rngnum = "";
    this.rngdir = "";
    this.secnum = "";
    this.secdtl = "";
    this.latdir = "";
    this.latdd = "";
    this.longdir = "";
    this.longdd = "";
    this.locality = "";
    this.habitat = "";
    this.typespm = false;
    this.hpuri = "";
    this.hploc = "N";
    this.hphab = "N";
    this.hpdesc = "N";
    this.hpassoc = "N";
    this.hpannot = "N";
    this.images.removeAllElements();
    this.crmonth = "";
    this.crday = "";
    this.cryear = "";
  }
}
