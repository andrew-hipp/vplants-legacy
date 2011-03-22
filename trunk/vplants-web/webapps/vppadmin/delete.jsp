<%@ page import="java.io.*" %>
<html>
<head>
<title>Deleting dataset</title>
</head>

<body>
<jsp:include page="adminTop.html" flush="true"/>
<%@ include file="dbPrimary.jsp" %>

<% // editable table list

// from dbPrimary.jsp:
//   Connection dbConnection
//   ResultSet rs
//   Statement primaryStmt
//   String path
//   String database_id

String filename = request.getParameter("filename");
String table_id = request.getParameter("table_id");
try{
  File dataset = new File(path+"datasets/"+filename);
  
  // delete the file
  dataset.delete();

  // delete the dataset from the database
  primaryStmt.executeUpdate(
    "delete from datasets " +
    "where filename = '" + filename + "'"
  );
  %>Dataset Deleted.<br/><%
} catch (SQLException se) {
    out.println("SQL Error message: " + se.getMessage() + ".<br/>");
    se.printStackTrace();
} catch (Throwable ex) {
    out.println("Error deleting file "+path+"datasets/"+filename+"<br/>");
    ex.printStackTrace();
}finally{
  try {
    primaryStmt.close();
  }catch(Throwable ex) {
    // do nothing
  }
}
%>

<br/>
<a href="datasets.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>">Dataset List</a><br/>


</body>
