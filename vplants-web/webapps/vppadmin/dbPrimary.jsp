<%@ page
import="java.sql.*"
import="java.util.*"
%>

<%@ include file="MultipartParameter.jsp" %>
<jsp:useBean id="getConnection" scope="session" class="org.vplants.utils.GetConnection" />
<%

MultipartParameter multipartParameter = null;

String database_id = request.getParameter("database_id");
if(database_id == null && request.getContentType() != null) {
  multipartParameter = new MultipartParameter(request);
  database_id = multipartParameter.getParameter("database_id");
}

// find the path of this directory
String path = getServletContext().getRealPath(request.getRequestURI()).replace('\\', '/');
path = path.substring(0,path.lastIndexOf("vppadmin"));

// get database connection
ResultSet rs          = null;
Connection dbPrimary = getConnection.connect(path);
Statement primaryStmt = null;;
if(dbPrimary == null) {
  out.println("<b>Error opening database</b><br/>");
} else {
  primaryStmt = dbPrimary.createStatement();
}

%>


