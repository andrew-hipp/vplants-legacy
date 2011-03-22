package org.vplants.bot;

import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.vplants.arch.*;

/**
  * Sax handler object for the vPlants Metadata Index Layer.  This layer serves
  * as a table of contents for the site's metadata, providing the spider with
  * uri links to specific taxon pages.
  * <P>
  * The IndexHandler parses the index XML page, packaging the information into a
  * java object for further processing.
  * <P>
  * @author Matthew Schaub
  */
public class IndexHandler extends AbstractHandler {
/** Are we in a link object? */
  private boolean	link = false;
/** Are we in a taxon object? */
  private boolean taxon = false;
/** Are we in a herbCd object? */
  private boolean herbCd = false;

/** Local variable to store the current herbarium code */
  private String herbarium;
/** Vector for storing links to the taxon level pages */
  private Vector taxonVector = new Vector();

/**
  * For every element processed by the sax parser, a boolean variable corresponding
  * to the element name is set (true at the start tag, false at the end tag).  This
  * lets us know where we are at in the xml document, allowing for element-specific processing.
  * @param qName Current tag name
  * @param flag Boolean value
  */
  public void setFlag(String qName, boolean flag) {
   	if ("herbcd".equals(qName))
      herbCd = flag;
    else if ("taxon".equals(qName))
      taxon = flag;
   	else if ("link".equals(qName))
      link = flag;
  }

/**
  * Abstract method called everytime an end element is encountered.
  * This allows us to add links to the taxon vector and set the
  * current herbarium code.
  * @param temp Current tag's value
  */
  public void processNode(String temp) {

   	if (taxon && link) {
      taxonVector.add(temp);
    }
    else if (herbCd) {
      if (temp.equals("MOR"))
        herbarium = "MA";
      else if (temp.equals("F"))
        herbarium = "FM";
      else if (temp.equals("CHIC"))
        herbarium = "CB";
    }
  }

/**
  * Return the taxon vector.
  * @return Vector Taxon vector
  */
  public Vector getTaxonVector() {
    return taxonVector;
  }

/**
  * Return the herbarium code.
  * @return String Herbarium code
  */
  public String getHerbCd() {
    return herbarium;
  }

/**
  * Clear the object, setting all tag booleans to false.
  */
  public void clearFlags() {
    link = false;
    taxon = false;
    herbCd = false;
  }
}
