<html>
<head>
<title>Dataset List</title>
</head>

<body>

<jsp:include page="adminTop.html" flush="true"/>
<%@ include file="dbPrimary.jsp" %>

<table>
<tr>
<td>Creation Date</td>
<td>Description</td>
<td>Rows</td>
</tr>

<% // editable table list

// from dbPrimary.jsp:
//   Connection dbConnection
//   ResultSet rs
//   Statement primaryStmt
//   String path
//   String database_id

String table_id = request.getParameter("table_id");

try{
  rs = primaryStmt.executeQuery(
    "select description, creation_date, filename, num_rows " +
    "from datasets " +
    "where table_id = " + table_id + " " +
    "order by description"
  );   

  while(rs.next()){ // print all table data
    %><tr class="browseListText">
    
    <td><%= rs.getString("creation_date") %> </td>
    <td><%= rs.getString("description") %> </td>
    <td><%= rs.getString("num_rows") %> </td>
    <td><a href="datasets/<%= rs.getString("filename") %>">Download</a> </td>
    <td><a href="activate_conf.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>&filename=<%= rs.getString("filename") %>">activate</a> </td>
    <td><a href="delete_conf.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>&filename=<%= rs.getString("filename") %>">delete</a> </td>
    </tr><%
  }
} catch (SQLException se) {
    out.println("SQL Error message: " + se.getMessage() + ".<br/>");
    se.printStackTrace();
} catch (Throwable ex) {
    out.println("IO Error.<br/>");
    ex.printStackTrace();
}finally{
  try {
    primaryStmt.close();
  }catch(Throwable ex) {
    // do nothing
  }
}
%>

</table>

<br/>
<a href="create_dataset_conf.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>">Create New Data set</a><br/>
<a href="upload_dataset_conf.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>">Upload Data set</a>

</body>
</html>