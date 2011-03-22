package org.vplants.arch;

import java.util.*;
import java.io.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * A wrapper class for the CSV class, providing the functionality to open,
 * read, and parse the lines of a csv file.
 * This class can also return a Document version of the currently parsed line.
 * <P>
 * @author Matthew Schaub
 */
public class CSVFile extends Object {

/** CSV object for parsing out the tokens of line */
  CSV csv = new CSV();
/** Storage structure for the current elements text */
  BufferedReader is = null;
/** Field descriptions from the header row */
  Vector metadata = null;
/** Parsed tokens for the file's current line */
  Vector currLine = new Vector();
/** Is the first line a header row? */
  boolean firstLineMetadata;
/** Is the current line blank? */
  boolean blankLine = false;

/** Name of the root element for the document version of the current row */
  public static final String ROOT = "ROOT";

/**
 * Opens the file whose path is in the inFile parameter.  If the firstLineMetadata
 * parameter is set to true, the class will read the first line of the file,
 * storing it's parsed contents in a Vector.  This line is treated as the file's
 * header row.
 */
  public CSVFile(String inFile, boolean firstLineMetadata)
  throws IOException {

		is = new BufferedReader(new FileReader(inFile));

    this.firstLineMetadata = firstLineMetadata;

    // if the first line contains the column names (metadata), grab them
    // and load them into
    if (firstLineMetadata) {
      if (readLine()) {
        metadata = (Vector)currLine.clone();
      }
    }
  }

/**
 * Alternative constructor for files without a leading header row.
 */
  public CSVFile(String inFile)
  throws IOException {
    this(inFile, false);
  }

/**
 * Reads the next line from the file.  Contents are parsed and packaged into
 * a Vector.
 * @returns True if a line is available for reading, False if the file has ended
 */
  public boolean readLine()
  throws IOException {
		String line;
    int fieldCount = -1;

    currLine.removeAllElements();

    if ((line = is.readLine()) != null)
    {
        fieldCount = 0;
  		  Iterator f = csv.parse(line);
	  	  while (f.hasNext()) {
          String val = f.next().toString();
          currLine.addElement(val);
          fieldCount++;
        }
    }

/* klug - I added this for the Mac - for some reason it was sticking a blank
line between actual data lines.  I think it had something to do with the whole
carriage return, linefeed differences between IBM's and Macs.
*/
    if (fieldCount == 1)
      blankLine = true;
    else
      blankLine = false;

    if (fieldCount == -1)
      return false;
    else
      return true;
  }

/**
 * Returns a Vector representation of the files header row.
 * @returns Vector containing the fields in the header row.
 */
  public Vector getMetadata() {
    return this.metadata;
  }

/**
 * Returns a Vector representation of the files current row.
 * @returns Vector containing the fields in the current row.
 */
  public Vector getCurrentLine() {
    return this.currLine;
  }

/**
 * Converts the current line into a Document representation.
 * @returns Document representation of the current line
 */
  public Document getCurrentDocument() {

    Element root = new Element(ROOT);
    Document outdoc = new Document(root);

    int size = currLine.size();
    Object[] objects = currLine.toArray();
    String nodeName = "value";
	  for (int i = 0; i < size; i++)
    {
      if (firstLineMetadata)
        nodeName = metadata.elementAt(i).toString();

      Element data = new Element(nodeName);
      root.addContent(data);
      data.addContent(objects[i].toString());
	  }

    return outdoc;
  }

/**
 * Reports the status of the current line.
 * @returns True if the line is blank, False otherwise.
 */
  public boolean isBlankLine() {
    return blankLine;
  }
}
