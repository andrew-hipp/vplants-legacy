
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

/**
 * An object for storing specimen image information.
 * <P>
 * @author Matthew Schaub
 */
public class ImageObject extends Object {
/** Universal resource identifier for the image */
  private String uri = "";
/** Image type - full, preview, etc. */
  private String type = "";

/**
  * Constructor.
  * @param uri URI for the image
  * @param type Type of image
  */
  public ImageObject(String uri, String type) {
    this.uri = uri;
    this.type = type;
  }

/**
  * Default Constructor - creates an empty image object.
  */
  public ImageObject() {
    this("","");
  }

/**
  * Set the uri field.
  * @param temp URI value
  */
  public void setURI(String temp) {
    this.uri = temp;
  }

/**
  * Set the type field.
  * @param temp Type value (preview, full, etc.)
  */
  public void setType(String temp) {
    this.type = temp;
  }

/**
  * Get the uri value.
  * @return String URI
  */
  public String getURI() {
    return uri;
  }

/**
  * Get the type value.
  * @return String Type (preview, full, etc.)
  */
  public String getType() {
    return type;
  }

/**
  * Convert the type value into a code.
  * @return String Type Code (ie. preview -> SP, full -> SH)
  */
  public String getTypeCd() {
    String typeCd = "SH";

    if (type.equals("preview"))
      typeCd = "SP";
    else if (type.equals("full"))
      typeCd = "SH";
    else if (type.equals("flower"))
      typeCd = "FL";
    else if (type.equals("bud"))
      typeCd = "BD";
    else if (type.equals("fruit"))
      typeCd = "FR";
    else if (type.equals("seed"))
      typeCd = "SE";
    else if (type.equals("labal"))
      typeCd = "LA";
    else if (type.equals("map"))
      typeCd = "MP";
    else if (type.equals("site"))
      typeCd = "ST";

    return typeCd;
  }

/**
  * Get the format code for the image.  The format defaults to jpeg (format cd = "JP").
  * If the uri ends in ".sid", the image is a MrSid and the format cd is
  * set to "SD".
  * @return String Format Code
  */
  public String getFormatCd() {
    String formatCd = "JP"; // default to jpg

    if (uri.endsWith(".sid"))
      formatCd = "SD";      // MrSID

    return formatCd;
  }

/**
  * Convert the image information into a human-readable string value.
  * @return String Image URI [Image Type]
  */
  public String toString() {
    return uri + " [" + type + "]";
  }

/**
  * Confirms all the required fields are set.
  * @return boolean True/False
  */
  public boolean isValid() {
    if (
        (uri.length() > 0) &&
        (type.length() > 0)
       )
      return true;
    else
      return false;
  }

/**
  * Clears all data fields in the object.
  */
  public void clear() {
    uri = "";
    type = "";
  }
}
