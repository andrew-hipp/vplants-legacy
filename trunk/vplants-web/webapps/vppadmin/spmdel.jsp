<%@ page
  import="java.io.*"
  import="java.text.SimpleDateFormat"
  import="org.vplants.vppadmin.*"
%>

<html>
<head>
<title>Creating dataset</title>
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

Connection dbSecondary = null;
String database_name = null;

// get database connection
try{
  rs = primaryStmt.executeQuery(
    "SELECT database_name, url, login_id, login_password, driver " +
    "FROM databases " +
    "WHERE databases.database_id = " + database_id
  );

  if(!rs.next()){
    out.println("Cannot find database "+database_id+".<br/>");
  } else {
    database_name=rs.getString("database_name");

    dbSecondary = getConnection.connect(
      rs.getString("url"),
      rs.getString("login_id"),
      rs.getString("login_password"),
      rs.getString("driver")
    );
    if(dbSecondary == null) {
      out.println("Error opening database: " + rs.getString("url") + "<br>");
    } else {
		out.flush();
		
		// using the connection make the SpmDelRequest class 
		DelSpmRequest delSpmRequest = new DelSpmRequest(dbSecondary, request, response, request.getRemoteUser());
		
		// Figure out what to do based on query string parameters.
		if (request.getParameter("confirm_del") != null)
		{
			delSpmRequest.confirmDelete();
		}
		else if (request.getParameter("delete_spm") != null)
		{
			delSpmRequest.deleteSpm();
		}
		else
		{
			delSpmRequest.viewForm();
		}
    }
  }
} catch (SQLException se) {
    out.println("SQL Error message in spmdel.jsp: " + se.getMessage() + ".<br/>");
    se.printStackTrace();
} catch (Throwable ex) {
    out.println("IO Error in spmdel.jsp.<br/>");
    ex.printStackTrace();
}

%>

<br/>
</body>
</html>