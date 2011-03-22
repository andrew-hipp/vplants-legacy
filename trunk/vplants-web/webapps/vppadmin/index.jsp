<%@ page
import="java.sql.*"
import="java.util.*"
%>
<%@ include file="dbPrimary.jsp" %>

<html>
<head>
<title>Database List</title>
</head>

<body>

<jsp:include page="adminTop.html" flush="true"/>

<table>
<thead>
<td align="center"><b>Databases</b></td>
</thead><tr></tr>

<% // editable database list
// from dbPrimary.jsp:
//   Connection dbConnection
//   ResultSet rs
//   Statement primaryStmt
//   String path
//   String database_id

try{
  rs = primaryStmt.executeQuery(
    "select databases.database_id, database_name, table_id, table_name, spmdel " +
    "from databases, editable_tables " +
    "where databases.database_id = editable_tables.database_id " +
    "order by database_name, table_name"
  );

  while(rs.next()){ // print all table data
    // database changed
    if(database_id == null || !rs.getString("database_id").equals(database_id)) {
      database_id = rs.getString("database_id");
      %><tr height='8'/>
      <tr>
      <td><small><b><%= rs.getString("database_name") %></b></small></td>
      </tr><%
      if(rs.getString("spmdel").equals("1")) {
        out.println("<tr><td>&nbsp;&nbsp; <a href='spmdel.jsp?database_id="+database_id+"'>");
        out.println("Delete record from specimen table.</a></td></tr>");
      }
    }
    // tables for that database
    %><tr>
    <td>&nbsp;&nbsp; <a href="./datasets.jsp?database_id=<%= database_id %>&table_id=<%= rs.getString("table_id") %>"><%= rs.getString("table_name") %></a></td>
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

</body>
</html>