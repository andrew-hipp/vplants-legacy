<%@ page
import="java.io.*"
import="java.util.*"
%>

<%
class MultipartParameter {
  Vector parameterName;
  Vector parameter;
  
  String data = null;
  MultipartParameter(ServletRequest servletRequest) {
    parameterName = new Vector();
    parameter = new Vector();
    String ln;

    DataInputStream in = null;
    int contentLength = servletRequest.getContentLength();
    byte dataBytes[] = new byte[contentLength];
    int readPos = 0;
    int readTotal = 0;

    try {
      in = new DataInputStream(servletRequest.getInputStream());
      while (readTotal < contentLength) {
        readPos = in.read(dataBytes, readTotal, contentLength);
        readTotal += readPos;
      }

      data = new String(dataBytes);

      readPos=0;
      String boundary = data.substring(0,data.indexOf("\n"));

      // read the data
      while( (readPos = data.indexOf("name=\"",readPos)+6) != 5 ) {
        // get the parameter name
        parameterName.add( data.substring(readPos,data.indexOf("\"",readPos)) );
        readPos = data.indexOf("\n",readPos)+2;
        if(data.substring(readPos,data.indexOf("\n",readPos)).equals(""))
          readPos++;
        else
          readPos+=27;

        // read the data
        parameter.add(data.substring(readPos, data.indexOf(boundary,readPos)-2));
      }

    } catch (Throwable ex) {
      System.out.println("Unable to read POST data.");
    }
  }

  // gets the parameter names
  Enumeration getParameterNames() {
    return parameterName.elements();
  }
  
  // gets the parameter data for an parameter name
  String getParameter(String name) {
    int paramIndex = parameterName.indexOf(name);
    if(paramIndex == -1) {
      return null;
    } else {
      return ((String)parameter.elementAt(paramIndex));
    }
  }
  
  String getData() {
    return data;
  }
}
%>