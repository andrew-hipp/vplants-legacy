<%@ page
  import="java.io.*"
  import="java.text.SimpleDateFormat"
%>

<% // get database connection
String table_id;
String filename;
if(multipartParameter == null) {
  table_id = request.getParameter("table_id");
  filename = request.getParameter("filename");
} else {
  table_id = multipartParameter.getParameter("table_id");
  filename = multipartParameter.getParameter("filename");
}


Connection dbSecondary = null;
Statement secondaryStmt = null;

String table_name = null;
String database_name = null;

try{
  rs = primaryStmt.executeQuery(
    "SELECT database_name, url, login_id, login_password, driver, table_name " +
    "FROM databases, editable_tables " +
    "WHERE databases.database_id = " + database_id + " AND " +
    "editable_tables.table_id = " + table_id
  );

  if(!rs.next()){
    out.println("Cannot find database "+database_id+" or table "+table_id+".<br/>");
  } else {
    database_name=rs.getString("database_name");
    table_name=rs.getString("table_name");

    dbSecondary = getConnection.connect(
      rs.getString("url"),
      rs.getString("login_id"),
      rs.getString("login_password"),
      rs.getString("driver")
    );
    if(dbSecondary == null) {
      out.println("Error opening database: " + rs.getString("url") + "<br>");
    } else {
      secondaryStmt = dbSecondary.createStatement();
    }
  }
} catch (SQLException se) {
    out.println("SQL Error message in dbSecondary.jsp: " + se.getMessage() + ".<br/>");
    se.printStackTrace();
} catch (Throwable ex) {
    out.println("IO Error in dbSecondary.jsp.<br/>");
    ex.printStackTrace();
}
%>


