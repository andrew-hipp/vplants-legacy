
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.transformer;

import org.vplants.arch.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

/**
 * Extension of the CSVFile class with an added method for transforming the current
 * csv line using the parameter supplied XSL file.
 * <P>
 * @author Matthew Schaub
 */
public class CSVTransformFile extends CSVFile {
  TransformerFactory transFact;
  Templates templates;
  Transformer transformer = null;

  /**
   * Constructor method with added parameter for specifying the XSL filename.
   */
  public CSVTransformFile(String inFile, boolean firstLineMetadata, String xsltFilename)
  throws IOException, TransformerConfigurationException {

    super(inFile, firstLineMetadata);

    transFact = TransformerFactory.newInstance();
    Templates templates = transFact.newTemplates(
          new StreamSource(new File(xsltFilename)));
    transformer = templates.newTransformer();
  }

/** Transforms the current csv line (in Document format) using the
  * parameter supplied XSL file
  * @return String representation of the transformed line
  */
  public String transform()
  {
    StringBuffer sb = null;

    try {

      StringWriter sw = new StringWriter();
      StreamResult result = new StreamResult(sw);

      org.jdom.output.DOMOutputter outputter =
        new org.jdom.output.DOMOutputter();
      org.w3c.dom.Document domDocument =
        outputter.output(getCurrentDocument());
      javax.xml.transform.Source xmlSource =
        new javax.xml.transform.dom.DOMSource(domDocument);

      transformer.transform(xmlSource, result);

      sb = sw.getBuffer();

    } catch (org.jdom.JDOMException e) {
      e.printStackTrace();
    } catch (javax.xml.transform.TransformerException e) {
      e.printStackTrace();
    }

    return new String(sb);
  }
}

 