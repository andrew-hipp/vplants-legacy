// Copyright (c) 2000 The Morton Arboretum
package org.vplants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import oracle.jdeveloper.layout.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
//import org.jdom.input.Builder;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class vplantsXMLify extends JFrame {
  final JFileChooser fileChooser = new JFileChooser();
  final JFileChooser dirChooser = new JFileChooser();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JTextField filePathTextField = new JTextField();
  JButton selectFileButton = new JButton();
  JButton selectDirButton = new JButton();
  JLabel jLabel1 = new JLabel();
  JButton convertButton = new JButton();
  JTextField dirPathTextField = new JTextField();
  JLabel jLabel2 = new JLabel();
  String filePath = null;
  String dirPath = null;

  public vplantsXMLify() {

/*
    FileFilter filter = new FileFilter();
    filter.addType("htm");
    filter.addType("html");
    filter.setDescription("HTML files");

    chooser.addChoosableFileFilter(filter);
*/

    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void showFileChooser() {
    int returnVal = fileChooser.showOpenDialog(this.getParent());

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      filePath = fileChooser.getSelectedFile().getPath();
      filePathTextField.setText(filePath);
    }
  }

  private void showPathChooser() {
    dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    if (dirChooser.isDirectorySelectionEnabled())
      System.err.println("GOT IT");
    int returnVal = dirChooser.showOpenDialog(this.getParent());

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      dirPath = dirChooser.getSelectedFile().getPath();
      dirPathTextField.setText(dirPath);
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args) {
/*
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
*/
    vplantsXMLify f = new vplantsXMLify();
    f.setTitle("vPlants XML Metadata Generator");
    f.setSize(600, 150);
//    f.pack();
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height) / 2);
    f.setVisible(true);
//    f.addWindowListener(new WindowClosed(f, true));
  }

  private static boolean setValidation    = false; //defaults
  private static boolean setNameSpaces    = false;
  private static boolean setSchemaSupport = false;
  private static boolean setSchemaFullSupport = false;

  XMLReader producer;
  vplantsMetadataHandler consumer;

  private void convertFile() {
/******************************************/

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
	    consumer = new vplantsMetadataHandler(dirPath) {
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
      producer.parse ("file:///" + filePath);
//      producer.parse ("http://vplants.mortonarb.org/xsql/metadata/vpidx.xsql");
//      producer.parse ("file:///c:\\vplants\\xsd\\vpdtl.xml");
//      producer.parse ("file:///c:\\xml\\xerces~1\\data\\person~1.xml");
//      producer.parse ("file:///c:\\xml\\xerces~1\\data\\personal.xml");

    } catch (IOException e) {
            System.err.println ("I/O error: ");
      	    e.printStackTrace ();
    } catch (SAXException e) {
            System.err.println ("Parsing error: ");
	          e.printStackTrace ();
    }


    JOptionPane.showMessageDialog(this,
      "Parsing Complete!",
      "Transmogrify Status",
      JOptionPane.INFORMATION_MESSAGE);
/*
    try {
      DOMBuilder builder = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
//      DOMBuilder builder = new DOMBuilder("org.jdom.adapters.OracleV2DOMAdapter");
      Document indoc = builder.build(new File(filePath));

// create the output document
//      Document outdoc = new Document(new Element("root"));
//      printDocument(outdoc);
    } catch (JDOMException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
*/
  }

  private void printDocument(Document doc) throws IOException {
    XMLOutputter fmt = new XMLOutputter();
//    fmt.output(doc, System.out);
//    fmt.output(doc, new FileOutputStream(new File(outfile)));
  }

  private void jbInit() throws Exception {



    selectFileButton.setText("Select");
    selectFileButton.setMnemonic(KeyEvent.VK_S);
    selectFileButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        showFileChooser();
      }
    });

    selectDirButton.setText("Select");
    selectDirButton.setMnemonic(KeyEvent.VK_E);
    selectDirButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        showPathChooser();
      }
    });

    jLabel1.setText("Select XML File To Convert:");

    filePathTextField.setEditable(false);
    filePathTextField.setEnabled(false);
    filePathTextField.setDisabledTextColor(Color.black);
    dirPathTextField.setEditable(false);
    dirPathTextField.setEnabled(false);
    dirPathTextField.setDisabledTextColor(Color.black);

    jLabel2.setText("XML Hierarchy Root Directory:");
    convertButton.setText("XML-ify");
    convertButton.setMnemonic(KeyEvent.VK_X);
    convertButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        convertFile();
      }
    });

    this.getContentPane().setLayout(gridBagLayout1);
    this.getContentPane().add(filePathTextField, new GridBagConstraints2(0, 1, 2, 1, 1.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 4), 0, 0));
    this.getContentPane().add(selectFileButton, new GridBagConstraints2(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    this.getContentPane().add(jLabel1, new GridBagConstraints2(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 8, 0, 0), 0, 0));
    this.getContentPane().add(convertButton, new GridBagConstraints2(0, 4, GridBagConstraints.REMAINDER, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(4, 0, 0, 0), 0, 0));
    this.getContentPane().add(dirPathTextField, new GridBagConstraints2(0, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 4), 0, 0));
    this.getContentPane().add(selectDirButton, new GridBagConstraints2(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    this.getContentPane().add(jLabel2, new GridBagConstraints2(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 8, 0, 0), 0, 0));

    filePath = "c:\\xml\\xmlcutter\\sampleXML.xml";
    filePathTextField.setText(filePath);
    dirPath = "c:\\xml\\xmlcutter\\stage";
    dirPathTextField.setText(dirPath);

  }
}
