
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.arch;

/**
 * Standardized error reporting class thrown anytime an error or
 * exception is encountered.
 *
 * Currently, this class only prints out a basic message detailing the
 * error or exception.
 * <P>
 * @author Matthew Schaub
 */
public class ErrorObject extends Object {

  /**
   * Reports the area in the code and the specific error message.
   */
  public ErrorObject(String area, String mesg) {
    System.err.println("ERROR: " + area + ", [" + mesg + "]");
  }

  /**
   * Reports the record # where the error occured along with the
   * area in the code and the specific error message.
   */
  public ErrorObject(int rec, String area, String mesg) {
    System.err.println("ERROR Record " + rec + ": " + area + ", [" + mesg + "]");
  }
}

