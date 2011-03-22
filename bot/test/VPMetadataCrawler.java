package org.vplants.bot;

import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.util.Vector;

/**
 * SAX2 Application Skeleton
 */
public class VPMetadataCrawler {

    private static boolean setValidation    = true; //defaults
    private static boolean setNameSpaces    = true;
    private static boolean setSchemaSupport = true;
    private static boolean setSchemaFullSupport = false;

    // argv[0] must be the absolute URL of an XML document
    public static void main (String argv [])
    {
        XMLReader       producer;
        VPMetadataHandler  consumer;

        long t0 = System.currentTimeMillis();

        String className = "org.apache.xerces.parsers.SAXParser";

        // Get an instance of the default XML parser class
        try {
            producer = XMLReaderFactory.createXMLReader(className);

            producer.setFeature( "http://xml.org/sax/features/validation",
                                               setValidation);

            producer.setFeature( "http://xml.org/sax/features/namespaces",
                                               setNameSpaces );

            producer.setFeature( "http://apache.org/xml/features/validation/schema",
                                               setSchemaSupport );

            producer.setFeature( "http://apache.org/xml/features/validation/schema-full-checking",
                                               setSchemaFullSupport );

        } catch (SAXException e) {
            System.err.println (
                  "Can't get parser, check configuration: "
                + e.getMessage ());
            return;
        }

	// set up the consumer
	try {

	    // Get a consumer for all the parser events
	    consumer = new VPMetadataHandler() {
        public void error (SAXParseException e)
        throws SAXException
          {throw e;}
      };

	    // Connect the most important standard handler
	    producer.setContentHandler(consumer);

	    // Arrange error handling
	    producer.setErrorHandler(consumer);
	} catch (Exception e) {
	    // consumer setup can uncover errors,
	    // though this simple one shouldn't
	    System.err.println (
	          "Can't set up consumers:"
                + e.getMessage ());
            return;
	}

        // Do the parse!
        try {

//            producer.parse ("file:///c:\\vplants\\xsd\\vpdtl.xml");
//            producer.parse ("file:///c:\\xml\\xerces~1\\data\\person~1.xml");
//            producer.parse ("file:///c:\\xml\\xerces~1\\data\\personal.xml");
//            producer.parse (argv [0]);

// start with the index page
            producer.parse("http://redwood.mortonarb.org/xsql/metadata/test.xml");
//            producer.parse("http://vplants.mortonarb.org/xsql/metadata/vphdr.xsql?id=5");

// then hit the taxon pages one at a time
            java.util.Vector taxon = consumer.getTaxonVector();

            String taxonLink;
            int taxonCount = 0;

            java.util.Vector spm;
            String spmLink;

            while (!taxon.isEmpty()) {
              taxonLink = taxon.firstElement().toString();

              System.err.println("TAXON: " + ++taxonCount + " " + taxonLink + "]");
              producer.parse(taxonLink);

// hit the specimen links
              spm = consumer.getSpmVector();
              while (!spm.isEmpty()) {
                spmLink = spm.firstElement().toString();
                System.err.println("SPM: " + spmLink);
                producer.parse(spmLink);
                spm.removeElementAt(0);
              }
              consumer.clearSpmVector();

              taxon.removeElementAt(0);
            }

        } catch (IOException e) {
            System.err.println ("I/O error: ");
      	    e.printStackTrace ();
        } catch (SAXException e) {
            System.err.println ("Parsing error: ");
	          e.printStackTrace ();
        }

        long t1 = System.currentTimeMillis();

        long runTime = t1 - t0;
        System.err.println("runTime= " + msToSecs(runTime));

  }

	public static String msToSecs(long t) {
		return t/1000 + "." + t%1000;
	}

}
