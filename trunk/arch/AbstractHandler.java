package org.vplants.arch;

import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
  * Abstract class for consuming Sax parser events from a producer.
  * <P>
  * A Sax parser may not return all of the characters within a node in a
  * single <i>characters()</i> call.  This class handles this odd behavior
  * by appending the characters into a StringBuffer and only calling the
  * <i>processNode</i> method once the end element is found.
  * <P>
  * @author Matthew Schaub
  */
public abstract class AbstractHandler extends DefaultHandler {

/** String buffer to hold the text contents of the current node */
  private StringBuffer chars = new StringBuffer();

/** Indicates the start element is found, triggering the setting of a boolean
  * variable to indicate the current element name.
  * This method can be overriden to include additional pre-functionality.
  * @param uri Namespace uri
  * @param local Local name
  * @param qName Qualified name (xml element tag name)
  * @param atts Attributes attached to the element
  */
  public void startElement(
  	String uri,
   	String local,
   	String qName,
   	Attributes atts
  )
  throws SAXException
  {
    setFlag(qName, true);
  }

/** Indicates the end element is found, triggering the setting of a boolean
  * variable to indicate the current element name has been terminated.
  * The abstract method processNode method is called, allowing for element processing.
  * This method can be overriden to include additional post-functionality.
  * @param uri Namespace uri
  * @param local Local name
  * @param qName Qualified name (xml element tag name)
  */
  public void endElement(String uri, String local, String qName)
  throws SAXException
  {
    processNode(getCharacters());

    setFlag(qName, false);
  }

/** As indicated in the general description, this method might only return
  * a subset of the characters contained in the current elements tags.  Subsequent
  * calls will retrieve all of the characters.  To handle this, we will append all
  * characters into a StringBuffer until the end element is found, indicating that
  * all characters are reporting.
  * @param buf[] Character array
  * @param offset Offset location within the character array
  * @param length # of characters for the current call
  */
  public void characters(char buf [], int offset, int length)
  {
    chars.append(buf, offset, length);
  }

/** Returns everything in the StringBuffer.  Most importantly, this method also
  * clears the StringBuffer for later use.
  * @returns A String for the current element's text
  */
  public String getCharacters() {

    int end = chars.length();
    int start=0;

    char[] array = new char[end];

    chars.getChars(0, end, array, 0);

    while (start<end && Character.isWhitespace(array[start])) start++;
    while (start<end && Character.isWhitespace(array[end-1])) end--;

    String retval = chars.substring(start, end);
    clearBuffer();
    return retval;
  }

/** Clears StringBuffer by setting it's length to 0
  */
  public void clearBuffer() {
    chars.setLength(0);
  }

/**
  * Abstract method for setting boolean variables corresponding to the element names.
  * This aids in element-specific functionality (e.g., if (name_element == true) do
  * something.
  * @param qName Element name
  * @param flag Boolean value
  */
  abstract public void setFlag(String qName, boolean flag);

/**
  * Abstract method for resetting boolean variables corresponding to the element names.
  * All flags will be set to false.
  */
  abstract public void clearFlags();

/**
  * Abstract method called everytime an end element is encountered.  This allows for
  * post element processing.
  * @param temp Current nodes contents
  */
  abstract public void processNode(String temp);

/**
  * Propogate sax errors to the parent.
  * @param e SaxParseException
  */
  public void error(SAXParseException e)
  throws SAXException {
    throw e;
  }
}
