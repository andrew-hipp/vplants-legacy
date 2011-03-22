package org.vplants.transformer;

import javax.swing.*;
import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.vplants.arch.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.*;
import javax.xml.transform.stream.*;

/**
 * Consumer class within the Sax parser.  This class handles the element level
 * processing that takes place on each CSV line (already transformed to the
 * standard blueprint state).
 * <P>
 * @author Matthew Schaub
 */
public class HdrHandler extends AbstractHandler {
/** Destination directory for all xml files created by the class */
  private String outpath;
/** URI base address where the documents will be published */  
  private String uriBase;

/** current name code */
  private String currNameCd = "";
/** current specimen id */
  private String currSpmId = "";
/** local storage of all unique name codes processed by the class - used to build
  * the index.xml page.
  */  
  private Vector nameCdVector = new Vector();

/** local storage of all specimen header information processed by the class - used
  * to build the taxon level xml page.
  */
  private Vector spmHdrVector = new Vector();
/** individual specimen header record */
  private SpmHdr spmHdr = new SpmHdr();

/** visible status field, used to report the current name code */
  private JTextField status;
/** generic counter */
  int count = 0;

  private boolean spmhdr = false;
  private boolean namecd = false;
  private boolean spmid = false;
  private boolean updttm = false;
  private boolean month = false;
  private boolean day = false;
  private boolean year = false;
  private boolean hour = false;
  private boolean min = false;

/** Transformer factory */
  TransformerFactory transFact = null;
/** Taxon level transformer */
  Transformer taxonTransformer = null;
/** Template holder for the taxon level XSL sheet */
  Templates templates = null;

/** Constructor method - loads all local variables and creates the
  * taxon level tranformation components.
  */
  public HdrHandler(String outpath, String uriBase, JTextField status)
  throws TransformerConfigurationException
  {
    super();

    this.outpath = outpath;
    this.uriBase = uriBase;
    this.status = status;

    /* prepare the taxon transformer */
    transFact = TransformerFactory.newInstance();
    templates = transFact.newTemplates(
      new StreamSource(new File("xsl/taxon.xsl")));    
//      new StreamSource(new File("org/vplants/transformer/taxon.xsl")));
    taxonTransformer = templates.newTransformer();
  }

/** Sets the element specific booleans to indicate where we are at in the
  * XML document
  */
  public void setFlag(String qName, boolean flag) {
   	if ("NAME_CD".equals(qName))
      namecd = flag;
   	else if ("SPM_ID".equals(qName))
      spmid = flag;
   	else if ("UPDTTM".equals(qName))
      updttm = flag;
   	else if ("MONTH".equals(qName))
      month = flag;
   	else if ("DAY".equals(qName))
      day = flag;
   	else if ("YEAR".equals(qName))
      year = flag;
   	else if ("HOUR".equals(qName))
      hour = flag;
   	else if ("MIN".equals(qName))
      min = flag;
   	else if ("SPM_HDR".equals(qName))
      spmhdr = flag;
  }

/** Overrides the parent's startElement to catch when a new specimen header begins.
  * Everytime a new SPM_HDR element is hit, we will create a new object to store
  * the spm header data.
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

    if (qName.equals("SPM_HDR")) {
      spmHdr = new SpmHdr();
    }
  }

/** Overrides the parent's endElement to catch when a specimen header ends.
  * At this point, the spm header object, created in the startElement method,
  * is placed on a Vector representing all spm header information falling under
  * the current name code.  This Vector will be used to build a taxon.xml for
  * the current name code.
  */
  public void endElement(
  	String uri,
   	String local,
   	String qName
  )
  throws SAXException
  {
    if (qName.equals("SPM_HDR")) {
      spmHdrVector.add(spmHdr);
    }

    super.endElement(uri, local, qName);
  }

/** Analyzes each element, loading the specimen header data and checking
  * to see if the name_cd has changed.  If it has, we will closeout the last
  * unique name_cd before we proceed to the next.
  */
  public void processNode(String temp)
  {
    if (namecd) {
// is this name code different than the current name code?
      if (!(currNameCd.equals(temp))) {
        if (currNameCd.length() != 0) { // screens out the first pass
          closeoutSpmHdr();
        }

        nameCdVector.add(temp);

        currNameCd = temp;

        // create a directory for new namecd
        new File(outpath + "/" + temp.substring(0,1) + "/" + temp).mkdirs();

        Runnable doLater = new Runnable() {
          public void run() {
            status.setText(currNameCd);
          }
        };
        SwingUtilities.invokeLater(doLater);
      }
    } else if (spmid) {
        spmHdr.setSpmid(temp);
        currSpmId = temp;
    } else if (updttm) {
      if (month)
        spmHdr.setMonth(temp);
      else if (day)
        spmHdr.setDay(temp);
      else if (year)
        spmHdr.setYear(temp);
      else if (hour)
        spmHdr.setHour(temp);
      else if (min)
        spmHdr.setMin(temp);
    }
  }

/** Access to the name_cd Vector used to build the index.xml
  * @return Vector containing all processed name_cd's.
  */
  public Vector getNameCdVector() {
    return nameCdVector;
  }

/** Access to the spm header information for the current name_cd.  Used to build
  * the taxon.xml page for the current name_cd.
  * @return Vector containing all spm_header objects for the current name_cd
  */
  public Vector getSpmHdrVector() {
    return spmHdrVector;
  }

/** Converts the specimen header records for the current name_cd into a Document
  * model, then transforms the document model into a taxon.xml page.
  */
  public void closeoutSpmHdr()
  {
    Element root = new Element("ROOT");
    Document taxonDoc = new Document(root);

    Element namecdE = new Element("NAME_CD");
    namecdE.addContent(this.currNameCd);
    root.addContent(namecdE);

    Element uriE = new Element("URI_BASE");
    uriE.addContent(uriBase);
    root.addContent(uriE);

    while (!(spmHdrVector.isEmpty())) {
      root.addContent(((SpmHdr)spmHdrVector.firstElement()).getElement());
      spmHdrVector.removeElementAt(0);
    }

    String spmHdrFilename = outpath + "/" + currNameCd.substring(0,1) +
      "/" + currNameCd + ".xml";

    try {
      org.jdom.output.DOMOutputter outputter =
        new org.jdom.output.DOMOutputter();
      org.w3c.dom.Document domDocument =
        outputter.output(taxonDoc);
      javax.xml.transform.Source xmlSource =
        new javax.xml.transform.dom.DOMSource(domDocument);

      taxonTransformer.transform(xmlSource, new StreamResult(new File(spmHdrFilename)));

    } catch (JDOMException je) {
      new ErrorObject("JDOMException Transforming " + currNameCd + " Taxon Page",
            je.getMessage());
    } catch (TransformerException te) {
      new ErrorObject("TransformerException Transforming " + currNameCd + " Taxon Page",
            te.getMessage());    }
  }

/** Supplies the current name_cd.
  * @return String representation of the current name_cd
  */
  public String getCurrNameCd() {
    return currNameCd;
  }

/** Supplies the current specimen id.
  * @return String representation of the current specimen id.
  */
  public String getCurrSpmId() {
    return currSpmId;
  }

  public void clearFlags() {
    spmhdr = false;
    namecd = false;
    spmid = false;
    updttm = false;
    month = false;
    day = false;
    year = false;
    hour = false;
    min = false;
  }
}
