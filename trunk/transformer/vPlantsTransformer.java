// Copyright (c) 2000 The Morton Arboretum
package org.vplants.transformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import oracle.jdeveloper.layout.*;
import org.vplants.arch.*;

/**
 * Driver class for the vPlants Metadata Transformer.
 * In summary, this application takes a flat file database consisting
 * of one single table and converts it into the vPlants metadata
 * standard format.
 *
 * Tailoring this application to a specific site requires the user to
 * create an XSL translation sheet mapping their site's data fields to a
 * set of predetermined data fields (See Example, blueprint.xsl).  The
 * application then transforms each row of the table into this standard,
 * blueprint format and then, through a series of additional translations,
 * creates a directory structure matching the vPlants metadata structure.
 *
 * <P>
 * @author Matthew Schaub
 */
public class vPlantsTransformer extends JFrame {
/** constant representing the program INI file */
  final static String INI_FILE = "vPlantsTransformer.ini";

/** File chooser for the data file to be converted */
  final JFileChooser fileChooser = new JFileChooser();
/** Directory chooser for the destination directory for the programs output */
  final JFileChooser dirChooser = new JFileChooser();
/** File chooser for the translation sheet used to map the site's data fields to
 * the blueprint format */
  final JFileChooser xsltChooser = new JFileChooser();

/** Layout Manager */
  GridBagLayout gridBagLayout1 = new GridBagLayout();

/** Select input file button */
  JButton selectFileButton = new JButton();
/** Select output directory button */
  JButton selectDirButton = new JButton();
/** Select XSL file button */
  JButton selectXsltButton = new JButton();
/** Button for running the translation */
  JButton convertButton = new JButton();

/** Data file path */
  JTextField filePathTextField = new JTextField();
/** Output directory path */
  JTextField dirPathTextField = new JTextField();
/** XSL file path */
  JTextField xsltPathTextField = new JTextField();
/** Herbarium code input */
  JTextField herbTextField = new JTextField();
/** Field used to indicate the web published URI for the metadata */
  JTextField uriTextField = new JTextField();
/** Status text field used to record the current name_cd */
  JTextField statusTextField = new JTextField();

/** Internal copy of the input file path */
  String filePath = null;
/** Internal copy of the output directory */
  String dirPath = null;
/** Internal copy of the XSL file path */
  String xsltPath = null;

/** Scrollable area for the applications output window */
  JScrollPane jScrollPane1 = new JScrollPane();
/** Text area for the output window */
  JTextArea results = new JTextArea();
/** Hotwired print stream for the output window */
  TextAreaPrintStream ps;

  JLabel xsltLabel = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();

/** Pipeline the data passes through to receive a series of translations */
  public TransformerPipeline tp;

/** Constructer for the applications frame */
  public vPlantsTransformer() {
    try  {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

/** Method for diplaying and updating the input file selection. */
  private void showFileChooser() {
    int returnVal = fileChooser.showOpenDialog(this.getParent());

    if (returnVal == JFileChooser.APPROVE_OPTION) {
//      filePath = fileChooser.getSelectedFile().getPath();
      filePathTextField.setText(fileChooser.getSelectedFile().getPath());
    }
  }

/** Method for displaying and updating the output directory selection. */
  private void showPathChooser() {
    dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

//    if (dirChooser.isDirectorySelectionEnabled())
//      System.err.println("GOT IT");
    int returnVal = dirChooser.showOpenDialog(this.getParent());

    if (returnVal == JFileChooser.APPROVE_OPTION) {
//      dirPath = dirChooser.getSelectedFile().getPath();
      dirPathTextField.setText(dirChooser.getSelectedFile().getPath());
    }
  }

/** Method for displaying and updating the XSL file selection. */
  private void showXsltChooser() {
    int returnVal = xsltChooser.showOpenDialog(this.getParent());

    if (returnVal == JFileChooser.APPROVE_OPTION) {
//      xsltPath = xsltChooser.getSelectedFile().getPath();
      xsltPathTextField.setText(xsltChooser.getSelectedFile().getPath());
    }
  }

  /**
   * Main method used to instantiate and execute the class.
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

    vPlantsTransformer f = new vPlantsTransformer();
    f.setTitle("vPlants Metadata Transformer");
    f.setSize(600, 500);
//    f.pack();
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height) / 2);
    f.setVisible(true);
//    f.addWindowListener(new WindowClosed(f, true));
  }

/** Called when the transform button is pressed, this method creates a new
  * pipeline and converts the current file
  */
  private void convertFile() {

    filePath = filePathTextField.getText();
    dirPath = dirPathTextField.getText();
    xsltPath = xsltPathTextField.getText();

    tp = new TransformerPipeline(filePath,
          dirPath,
          herbTextField.getText(),
          uriTextField.getText(),
          xsltPath,
          ps, statusTextField);

    new Thread() {
      public void run() {
        tp.start();

        JOptionPane.showMessageDialog(null,
          "Tranformation Complete!",
          "vPlants Transformer Status",
          JOptionPane.INFORMATION_MESSAGE);

        statusTextField.setText("");
      }
    }.start();

  }

/** Method responsible for laying out all the GUI elements
  */
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

    xsltLabel.setText("Select The XSLT File For Your Data:");
    selectXsltButton.setText("Select");
    selectXsltButton.setMnemonic(KeyEvent.VK_C);
    selectXsltButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        showXsltChooser();
      }
    });

    jLabel1.setText("Select CSV File To Transform:");

/*
    filePathTextField.setEditable(false);
    filePathTextField.setEnabled(false);
    filePathTextField.setDisabledTextColor(Color.black);
    dirPathTextField.setEditable(false);
    dirPathTextField.setEnabled(false);
    dirPathTextField.setDisabledTextColor(Color.black);
    xsltPathTextField.setEditable(false);
    xsltPathTextField.setEnabled(false);
    xsltPathTextField.setDisabledTextColor(Color.black);
*/
    statusTextField.setEditable(false);
    statusTextField.setEnabled(false);
    statusTextField.setDisabledTextColor(Color.black);
    results.setEditable(false);
    results.setEnabled(false);
    results.setDisabledTextColor(Color.black);

    jLabel2.setText("Destination Directory:");
    convertButton.setText("Transmogrify");
    convertButton.setMnemonic(KeyEvent.VK_T);
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
    this.getContentPane().add(jLabel1, new GridBagConstraints2(0, 0, GridBagConstraints.RELATIVE, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(8, 8, 0, 0), 0, 0));
    this.getContentPane().add(convertButton, new GridBagConstraints2(0, 13, GridBagConstraints.REMAINDER, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8, 0, 8, 0), 0, 0));
    this.getContentPane().add(dirPathTextField, new GridBagConstraints2(0, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 4), 0, 0));
    this.getContentPane().add(selectDirButton, new GridBagConstraints2(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    this.getContentPane().add(jLabel2, new GridBagConstraints2(0, 2, GridBagConstraints.RELATIVE, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4, 8, 0, 0), 0, 0));
    this.getContentPane().add(herbTextField, new GridBagConstraints2(0, 7, 2, 1, 0.5, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 250), 0, 0));
    this.getContentPane().add(uriTextField, new GridBagConstraints2(0, 9, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 4), 0, 0));
    this.getContentPane().add(jLabel3, new GridBagConstraints2(0, 8, GridBagConstraints.RELATIVE, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4, 4, 0, 0), 0, 0));
    this.getContentPane().add(jLabel4, new GridBagConstraints2(0, 6, GridBagConstraints.RELATIVE, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4, 8, 0, 0), 0, 0));
    this.getContentPane().add(jScrollPane1, new GridBagConstraints2(0, 12, GridBagConstraints.REMAINDER, 1, 1.0, 1.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(4, 8, 8, 4), 0, 0));
    jScrollPane1.getViewport().add(results, null);
    this.getContentPane().add(jLabel5, new GridBagConstraints2(0, 10, GridBagConstraints.REMAINDER, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4, 4, 0, 0), 0, 0));

    this.getContentPane().add(xsltLabel, new GridBagConstraints2(0, 4, GridBagConstraints.RELATIVE, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4, 8, 0, 0), 0, 0));
    this.getContentPane().add(xsltPathTextField, new GridBagConstraints2(0, 5, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 4), 0, 0));
    this.getContentPane().add(selectXsltButton, new GridBagConstraints2(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
    this.getContentPane().add(statusTextField, new GridBagConstraints2(0, 11, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 8, 0, 350), 0, 0));


    Properties properties = new Properties();
    properties.load(new FileInputStream(INI_FILE));

//    filePath = "c:\\docume~1\\admini~1\\mydocu~1\\data\\small.csv";
//    filePath = "/transformer/fm.csv";
//    xsltPath = "/transformer/blueprint.xsl";
//    dirPath = "/transformer/stage";

    filePathTextField.setText(properties.getProperty("DEF_FILE"));
    dirPathTextField.setText(properties.getProperty("DEF_DIR"));
    xsltPathTextField.setText(properties.getProperty("DEF_XSLT"));
    herbTextField.setText(properties.getProperty("DEF_HERBCD"));
    uriTextField.setText(properties.getProperty("DEF_URI"));

    results.setEditable(false);
    jLabel5.setText("Runtime Status:");
    jLabel4.setText("Herbarium Code:");
    jLabel3.setText("URI Base:");
    pack();

    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        this_windowClosing(e);
      }
    });

    ps = new TextAreaPrintStream(new PipedOutputStream(), results);
    System.setErr(ps);
    System.setOut(ps);
  }

/** Window closing listener. */
  void this_windowClosing(WindowEvent e) {
    exitApplication();
  }

/** Closes the application, disposing of all resources. */
 	protected void exitApplication()
	{
	  this.setVisible(false);    // hide the Frame
		this.dispose();            // free the system resources
		System.exit(0);            // close the application
  }
}
