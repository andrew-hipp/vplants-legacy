// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

import java.util.Vector;

/**
 * An object for storing taxon layer information.
 * <P>
 * @author Matthew Schaub
 */
public class TaxonObject extends Object {
/** Checklist name code for the current taxon */
  private String nameCode = "";
/** Common names for the current name code */
  private Vector commonNames;
/** Specimen header objects for the taxon */
  private Vector spmHdrs;

/**
  * Constructor - initialize the common name and spm header vectors.
  */
  public TaxonObject() {
    commonNames = new Vector();
    spmHdrs = new Vector();
  }

/**
  * Set the current name code.
  * @param nameCode Checklist name code
  */
  public void setNameCode(String nameCode) {
    this.nameCode = nameCode;
  }

/**
  * Add a common name to the common name vector.
  * @param commonName Common name
  */
  public void addCommonName(String commonName) {
    commonNames.add(commonName);
  }

/**
  * Add a specimen header object to the specimen header vector.
  * @param SpmHdrObject Specimen header object
  */
  public void addSpmHdrObject(SpmHdrObject spmHdrObject) {
    spmHdrs.add(spmHdrObject);
  }

/**
  * Get the current name code.
  * @return String Current name code
  */
  public String getNameCode() {
    return nameCode;
  }

/**
  * Get the list of common names.
  * @return Vector Vector of common names
  */
  public Vector getCommonNames() {
    return commonNames;
  }

/**
  * Get the list of specimen header objects.
  * @return Vector Vector of specimen header objects
  */
  public Vector getSpmHdrs() {
    return spmHdrs;
  }

/**
  * Clear all local variables for the object.
  */
  public void clear() {
    nameCode = "";
    commonNames.clear();
    spmHdrs.clear();
  }
}

