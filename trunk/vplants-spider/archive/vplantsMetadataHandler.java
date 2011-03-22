package org.vplants;

import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.util.Vector;
//import org.vplants.*;
import org.jdom.output.XMLOutputter;
import java.io.*;
import org.jdom.Document;
import org.jdom.Element;
//import org.w3c.dom.Element;
import javax.swing.*;

public class vplantsMetadataHandler extends DefaultHandler {
  private String outpath;

  private StringBuffer chars = new StringBuffer();
  private String temp;
  private Document doc;
  private Element element;

  private Vector nameCdIndex = new Vector();
  private Vector spmIdIndex = new Vector();

  private String currNameCd = null;
  private String nameCd = null;
  private String spmId = null;
  private String spmdtlFilename;

  private File ofile;
  private FileOutputStream ostream;

  int count = 0;

  public vplantsMetadataHandler(String outpath) {
    super();

    this.outpath = outpath;

    doc = new Document(new Element("spm"));
  }

  public void startElement (
	  String uri,
	  String local,
	  String qName,
	  Attributes atts
  ) throws SAXException
  {
// if we are starting a new row
    if ("ROW".equals(qName)) {
// start a new document
      doc.setRootElement(new Element("spm"));
    }
  }

  public void endElement(String uri, String local, String qName)
  throws SAXException
  {

    temp = getCharacters();

    if ("ROOT".equals(qName)) {
      closeoutIndex();
    }
    else if ("ROW".equals(qName)) {
      closeoutSpm();
    }
    else {
      element = new Element(qName);
      element.addContent(temp);
      doc.getRootElement().addContent(element);
    }

    if ("NAME_CD".equals(qName)) {
      nameCd = temp;
    }
    else if ("SPM_ID".equals(qName)) {
      spmId = temp;
    }

  }

  public void characters(char buf [], int offset, int length)
  throws SAXException
  {
    chars.append(buf, offset, length);
  }

  public String getCharacters() {
    int end = chars.length();
    int start=0;

    char[] array = new char[end];

    chars.getChars(0, end, array, 0);

    while (start<end && Character.isWhitespace(array[start])) start++;
    while (start<end && Character.isWhitespace(array[end-1])) end--;

    String retval = chars.substring(start, end);
    chars.setLength(0);
    return retval;
  }

/*
  	if (nameCdB) {
  	  tempNameCd = new String (buf, offset, length);
      if (!(tempNameCd.equals(currNameCd))) {
        if (currNameCd != null)
          closeoutNameCd();
        currNameCd = tempNameCd;
        nameCdIndex.add(tempNameCd);

        // create a directory for spm in the current namecd
        new File(outpath + "/" + tempNameCd.substring(0,1) + "/" +
          tempNameCd).mkdirs();
      }
    }
    else if (spmidB) {
      tempSpmid = new String(buf, offset, length);
      spmidIndex.add(tempSpmid);
      spm.setSpmid(tempSpmid);
    }
    else if (lnameB) {
      spm.setLname(new String(buf, offset, length));
    }
    else if (fnameB) {
      spm.setFname(new String(buf, offset, length));
    }
    else
	    return;
*/
  private void closeoutIndex() {
  }

  private void closeoutSpm() {

// first see if this is the last use of this name code
      if (!(nameCd.equals(currNameCd))) {
        if (currNameCd != null)
          closeoutNameCd();
        currNameCd = nameCd;
        nameCdIndex.add(nameCd);

        // create a directory for spm in the current namecd
        new File(outpath + "/" + nameCd.substring(0,1) + "/" +
          nameCd).mkdirs();
      }

      spmIdIndex.add(spmId);

      createSpmXML();
  }

  private void closeoutNameCd() {
//    System.err.println("NAMECD: " + currNameCd);
//    System.err.println("[" + spmIdIndex + "]");

    spmIdIndex.clear();
  }

  private void createSpmXML() {
// determine it's filepath
      spmdtlFilename = outpath + "/" + currNameCd.substring(0,1) +
      "/" + currNameCd + "/" + spmId + ".xml";
//    System.err.println(spm.toString());
      printXMLDocument(spmdtlFilename);
  }

  private void printXMLDocument(String outfile)
  {
    try {
    XMLOutputter fmt = new XMLOutputter();
//    fmt.output(doc, System.out);

    javax.xml.transform.Source xsltSource =
      new javax.xml.transform.stream.StreamSource("c:\\xml\\xmlcutter\\test.xsl");
    javax.xml.transform.Result result =
      new javax.xml.transform.stream.StreamResult(new File(outfile));

    javax.xml.transform.TransformerFactory transFact =
      javax.xml.transform.TransformerFactory.newInstance();

    javax.xml.transform.Transformer trans =
      transFact.newTransformer(xsltSource);

    org.jdom.output.DOMOutputter outputter = new org.jdom.output.DOMOutputter();
    org.w3c.dom.Document domDocument = outputter.output(doc);
    javax.xml.transform.Source xmlSource = new javax.xml.transform.dom.DOMSource(domDocument);
//    javax.xml.transform.Source xmlSource =
//      new javax.xml.transform.stream.StreamSource("c:\\xml\\xmlcutter\\sampleXML.xml");

    trans.transform(xmlSource, result);

    System.err.println(++count);
//    ofile = new File(outfile);
//    ostream = new FileOutputStream(ofile);
//    fmt.output(doc, ostream);
//    ostream.close();
    } catch (org.jdom.JDOMException e) {
      e.printStackTrace();
    } catch (javax.xml.transform.TransformerException e) {
      e.printStackTrace();
    }
  }
}
