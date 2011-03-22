<%@ page
import="java.io.*"
import="java.util.*"
import="org.apache.commons.fileupload.*"
import="org.apache.commons.fileupload.disk.DiskFileItemFactory"
import="org.apache.commons.fileupload.servlet.*"
%>

<%
class MultipartParameter {
  Vector parameterName;
  Vector parameter;
  
//  String data = null;
  MultipartParameter(HttpServletRequest servletRequest) throws FileUploadException {
	  PrintWriter o = null;
		try {
			o = new PrintWriter(new FileOutputStream("/home/content1/tError.log"));
		} catch(FileNotFoundException fe) {}
	  
    parameterName = new Vector();
    parameter = new Vector();

    o.println("creating factory...");
	//  Create a factory for disk-based file items
    DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setRepository(new File("/home/content1/tomcat50-jwsdp/temp"));
	factory.setSizeThreshold(100000);

	o.println("creating upload from factory...");
	//     Create a new file upload handler
	ServletFileUpload upload = new ServletFileUpload(factory);

	ServletRequestContext context = new ServletRequestContext(servletRequest);
	o.println("Multipart="+upload.isMultipartContent(context));
	o.println("length="+context.getContentLength());
	o.println("encoding="+context.getCharacterEncoding());
	o.println("contentType="+context.getContentType());
	o.println("starting parsing...");
	o.flush();

	List items = null;
	//  Parse the request
	try {
	/* FileItem */ items = upload.parseRequest(servletRequest);
	} catch(Exception e) { o.println(e); e.printStackTrace(o); o.flush();}
	
	o.println("adding items...");
	o.flush();

	//  Process the uploaded items
	Iterator iter = items.iterator();
	while (iter.hasNext()) {
		FileItem item = (FileItem) iter.next();
		
		o.print("adding "+item.getFieldName());
	
		if (item.isFormField()) {
			parameterName.add(item.getFieldName());
			parameter.add(item.getString());
			o.println(" - '"+item.getString()+"'");
		} else {
			byte[] data = item.get();
			parameterName.add(item.getFieldName());

			if((data[0]&0xff)==0xef && (data[1]&0xff)==0xbb && (data[2]&0xff)==0xbf) {
				try {
					parameter.add(new String(data,"UTF-8"));
				} catch (UnsupportedEncodingException e) { }
			} else
				parameter.add(new String(data));
//			parameterName.add("file");
//			parameter.add(item.getFieldName());
			o.println(" - '"+item.get()+"'");
		}
		o.flush();
	}
	
	o.close();
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
  /*
  String getData() {
    return data;
  }
  */
}
%>
