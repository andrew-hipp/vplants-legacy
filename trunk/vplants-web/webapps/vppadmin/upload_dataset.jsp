<%@ page
import="java.text.*"
import="java.util.*"
%>
<html>
<head>
<title>Uploading dataset</title>
</head>

<body>

<jsp:include page="adminTop.html" flush="true"/>
<%@ include file="dbPrimary.jsp" %>
<%@ include file="dbSecondary.jsp" %>

<% // editable table list

// from dbPrimary.jsp:
//   Connection dbConnection
//   ResultSet rs
//   Statement primaryStmt
//   String path
//   String filename

// from dbSecondary.jsp:
//   ResultSet rs2
//   Connection dbSecondary
//   Statement secondaryStmt
//   String filename
//   String table_id
//   String table_name

String fileData = multipartParameter.getParameter("file");

// out.println("<pre>"+multipartParameter.getData()+"</pre>");
// out.println("<pre>"+fileData+"</pre>");

BufferedWriter dataset = null;
String date = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new java.util.Date());
try{
  if(table_name == null) {
    out.println("Table name not found.<br/>");
  } else {
    // get column tokens
    StringTokenizer fileDataTokens;
    if(fileData.indexOf("\r\n") != -1)
      fileDataTokens = new StringTokenizer(fileData, "\r\n");
    else if(fileData.indexOf("\n") != -1)
      fileDataTokens = new StringTokenizer(fileData, "\n");
    else
      fileDataTokens = new StringTokenizer(fileData, "\r");

    StringTokenizer columnTokens = new StringTokenizer(fileDataTokens.nextToken(), "\t");

    // check to see if the data is valid, from column names
    boolean validData = true;
    String column;
    boolean firstColumn = true;
    rs = secondaryStmt.executeQuery("select COLUMN_NAME from user_tab_columns where table_name = '" + table_name.toUpperCase()+"' order by COLUMN_ID");
    while(rs.next() && validData) {
      column = columnTokens.nextToken();
      if(!firstColumn && !column.equals(rs.getString("COLUMN_NAME"))
	|| firstColumn && !column.endsWith(rs.getString("COLUMN_NAME")) ) {
        validData = false;
        out.println("\""+rs.getString("COLUMN_NAME")+"\" is not the same as \"" + column +"\".<br>\n");
      }
      firstColumn = false;
    }
    if(columnTokens.hasMoreTokens()) validData = false;

    if(!validData) {
      %>Dataset invalid.<br/><%
    } else {
      dataset = new BufferedWriter(new FileWriter(path + "datasets/"+table_name+"_"+date+".txt"));

      %>Saving table data.<br><%
      dataset.write(fileData);

      // update database for dataset
      primaryStmt.execute(
        "insert into datasets " +
        "(table_id,description,creation_date,filename,num_rows) " +
        "values ('" + table_id + "','" +
          multipartParameter.getParameter("description").replaceAll("'","''") + 
          "',to_date('"+date+"','yyyy-mm-dd_hh24-mi-ss')" + ",'" + 
          table_name+"_"+date+".txt','" + fileDataTokens.countTokens() + 
        "')"
      );
	  %>Table data saved.<br/><%
	}
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
    dataset.close();
  }catch(Throwable ex) {
    // do nothing
  }
}
%>

<br/>
<a href="datasets.jsp?database_id=<%= database_id %>&table_id=<%= table_id %>">Dataset List</a><br/>

</body>
</html>
