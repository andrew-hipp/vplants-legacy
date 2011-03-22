
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.arch;

import java.io.*;
import javax.swing.*;
/**
 * Class for hotwiring a PrintStream, directing any text from the stream
 * to a user supplied JTextArea.  
 * <P>
 * @author Matthew Schaub
 */
public class TextAreaPrintStream extends PrintStream {

/** Local copy of the user supplied JTextArea - this is the destination of any
 * text sent to the PrintStream.
 */
  private JTextArea out;

  /**
   * Constructor for a hotwired JTextArea.
   */
  public TextAreaPrintStream(OutputStream os, JTextArea out) {
    super(os);

    this.out = out;
  }

  public void println(String x) {
    append(x + "\n");
  }

  public void println() {
    append("\n");
  }

  public void print(String x) {
    append(x);
  }

  private void append(String s) {
    final String x;
    x = s;
    Runnable doLater = new Runnable() {
      public void run() {
        out.append(x);
      }
    };
    SwingUtilities.invokeLater(doLater);
  }
}

