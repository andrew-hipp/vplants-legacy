// Copyright (c) 2000 The Morton Arboretum
package org.vplants.transformer;

import org.vplants.arch.*;
import java.io.*;
import java.util.Vector;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.transform.*;
import javax.xml.transform.sax.*;
import javax.xml.transform.stream.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import javax.swing.*;

/**
 * Each row of the input file passes through this method which brokers
 * a series of translations and a parse routine.
 * The order is as follows:
 * <ol>CSV Transformation - current line from the csv file is transformed into the
 *      blueprint format.</ol>
 * <ol>Hdr Parse - a sax parser grabs some of the high level summary data
 *      including the name_cd and the update dttm.  If the name_cd is different
 *      from the last row, a <b>taxon</b> level XML page is created.</ol>
 * <ol>Spm Transformation - current line is transformed into a <b>spm</b>
 *      level XML page.</ol>
 * <P>
 * @author Matthew Schaub
 */
public class TransformerPipeline extends Object {

/** CSV file */
  private CSVTransformFile csvFile;
/** Sax parser used to extract hdr information from the current line */
  private HdrParser hdrParser;
/** Spm level transformer */  
  private Transformer spmTransformer = null;

  private String inFile;
  private String outPath;
  private String herbCd;
  private String uriBase;
  private String xsltFile;
  private PrintStream ps;

/** Constructor method for the pipeline, specific to the details entered on
  * the application's frontend.
  */
  public TransformerPipeline(
    String inFile,
    String outPath,
    String herbCd,
    String uriBase,
    String xsltFile,
    PrintStream ps, JTextField status) {

    this.inFile = inFile;
    this.outPath = outPath;
    this.herbCd = herbCd;
    this.uriBase = uriBase;
    this.xsltFile = xsltFile;
    this.ps = ps;

    try {
      csvFile = new CSVTransformFile(inFile, true, xsltFile);
    } catch (IOException ie) {
      new ErrorObject("IOException Creating CSVTransformFile", ie.getMessage());
      return;
    } catch (TransformerException e) {
      new ErrorObject("TransformerException Creating CSVTransformFile", e.getMessage());
      e.printStackTrace();
      System.err.println(e.toString());
      System.err.println(e.getMessageAndLocation());
      return;
    }

/* prepare the hdr information parser */
    try {
      hdrParser = new HdrParser(outPath, uriBase, status);
    } catch (SAXException se) {
      new ErrorObject("SAXException Creating HdrParser", se.getMessage());
      return;
    } catch (TransformerConfigurationException e) {
      new ErrorObject("TransformerConfigurationException Creating HdrParser", e.getMessage());
      return;
    }

/* prepare the specimen transformer */
    try {
      TransformerFactory transFact;
      transFact = TransformerFactory.newInstance();
      Templates templates = transFact.newTemplates(
          new StreamSource(new File("xsl/spm.xsl")));      
//          new StreamSource(new File("org/vplants/transformer/spm.xsl")));
      spmTransformer = templates.newTransformer();
    } catch (TransformerConfigurationException e) {
      new ErrorObject("TransformerConfigurationException Creating HdrParser", e.getMessage());
      return;
    }
  }

/** Starts the transformation, passing the current csv row through the hoops.
  */
  public void start() {

    System.out.println("***BEGINNING TRANSFORMATION***");
    System.out.println("Start Time: " + new java.util.Date());
    System.out.println();

    long t0 = System.currentTimeMillis();

// begin reading each line of a CSV file
    int cnt = 1;
    String foo;

    try {
      while (csvFile.readLine()) {

        if (csvFile.isBlankLine())
          continue;
/*
        try {
          Thread.sleep(5*1000);
        } catch (java.lang.InterruptedException ie) {
          System.err.println("SLEEP!!!!");
        }
*/

// transform each line of the CSV into the standard blueprint format,
// bridging the sites data and the pieces needed to build the vPlants data
        foo = csvFile.transform();
//        System.out.println(foo);

// parse the blueprint to gather its hdr information - at this point, we need
// the name_cd and spm_id to create output files...
        try {
          hdrParser.parse(foo);

// transform the blueprint into the detailed specimen page
          String currNameCd = hdrParser.getCurrNameCd();

          String currSpmId = hdrParser.getCurrSpmId();

          String spmFilename = outPath + "/" + currNameCd.substring(0,1) +
                        "/" + currNameCd + "/" + currSpmId + ".xml";

          spmTransformer.transform(new StreamSource(new java.io.StringReader(foo)),
                    new StreamResult(new File(spmFilename)));

        } catch (TransformerException e) {
          new ErrorObject(cnt, "TransformerException Transforming SpmPage", e.getMessage());
        } catch (SAXException se) {
          new ErrorObject(cnt, "SAXException Parsing Taxon Information", se.getMessage());
        }

        ++cnt;
//        System.out.println(cnt + ": ");
      }
    } catch (IOException e) {
      new ErrorObject(cnt, "IOException Parsing CSVFile", e.getMessage());
    }


// close out the last spm hdr record
    hdrParser.closeoutSpmHdr();

//      System.err.println(hdrParser.getNameCdVector());
// finish by creating an index page based on the namecd vector created in the
// hdr parser
    closeoutIndex(outPath, herbCd, hdrParser.getNameCdVector());

    long t1 = System.currentTimeMillis();

    long runTime = t1 - t0;
    System.out.println();
    System.out.println("Records Processed: " + cnt);
    System.out.println("Elapsed Time: " + msToSecs(runTime));
    System.out.println("Elapsed Time: " + msToMins(runTime));

    System.out.println("End Time: " + new java.util.Date());
    System.out.println("***ENDING TRANSFORMATION***");
    System.out.println();
  }

/** Method used to convert milliseconds to seconds.
  * @return String representation of the seconds.
  */
	private String msToSecs(long t) {
		return t/1000 + "." + t%1000 + " seconds";
	}

/** Method used to convert milliseconds to minutes/seconds.
  * @return String representation of the minutes and seconds.
  */
	private String msToMins(long t) {
		return (t/1000)/60 + " minutes, " + (t/1000)%60 + " seconds";
	}

/** Once all rows have been processed, this method is called to generate the
  * single index XML page, summarizing the name_cd's stored in the directory
  * structure.
  */
  private void closeoutIndex(String outPath, String herbCd, Vector names) {
    Element root = new Element("ROOT");
    Document doc = new Document(root);

    Element herb = new Element("HERB_CD");
    herb.addContent(herbCd);
    root.addContent(herb);

    Element uriE = new Element("URI_BASE");
    uriE.addContent(uriBase);
    root.addContent(uriE);

    while (!(names.isEmpty())) {
      Element name = new Element("NAME_CD");
      name.addContent((String)names.firstElement());
      root.addContent(name);
      names.removeElementAt(0);
    }

    try {

      TransformerFactory transFact;
      transFact = TransformerFactory.newInstance();
      Transformer indexTransformer = null;
      Templates templates = transFact.newTemplates(
        new StreamSource(new File("xsl/index.xsl")));      
//        new StreamSource(new File("org/vplants/transformer/index.xsl")));
      indexTransformer = templates.newTransformer();

      org.jdom.output.DOMOutputter outputter =
        new org.jdom.output.DOMOutputter();
      org.w3c.dom.Document domDocument =
        outputter.output(doc);
      javax.xml.transform.Source xmlSource =
        new javax.xml.transform.dom.DOMSource(domDocument);

      String indexHdrFilename = outPath + "/index.xml";

      indexTransformer.transform(xmlSource, new StreamResult(new File(indexHdrFilename)));

    } catch (JDOMException je) {
      System.err.print("closeoutIndex: ");
      je.printStackTrace();
    } catch (TransformerException te) {
      System.err.print("closeoutIndex: ");
      te.printStackTrace();
    }
  }
}
