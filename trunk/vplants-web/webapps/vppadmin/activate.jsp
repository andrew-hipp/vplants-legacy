<html>
<head>
<title>Activating dataset</title>
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
//   String database_id

// from dbSecondary.jsp:
//   ResultSet rs2
//   Connection dbSecondary
//   Statement secondaryStmt
//   String filename
//   String table_id
//   String table_name

BufferedReader dataset = null;
StringBuffer sql = new StringBuffer();
int columnNum, valueNum;

try{
  // open the file
  dataset = new BufferedReader(new FileReader(path+"datasets/"+filename));

  StringBuffer columnNames = new StringBuffer(dataset.readLine());
  String line;
  StringBuffer values = new StringBuffer();
  int i;

  columnNum = 1;
  i=0;
  while(
    (i<columnNames.length()) &&
    (i=columnNames.indexOf("\t", i)) != -1
  ) {
    columnNames.replace(i,i+1,",");
    i++;
    columnNum++;
  }

  // empty table before inserting values
  secondaryStmt.executeUpdate("delete from " + table_name);

  // update database from dataset
  while((line=dataset.readLine()) != null) {
    values.setLength(0);
    sql.setLength(0);
    values.append(line);

    // replaces ' in the line with ''
	i=0;
    while(
      (i<values.length()) &&
      (i=values.indexOf("'", i)) != -1
    ) {
      values.replace(i,i+1,"''");
      i+=2;
    }

    // replaces tabs in the line with "','"
	i=0;
    valueNum=1;
    while(
      (i<values.length()) &&
      (i=values.indexOf("\t", i)) != -1
    ) {
      // replace the \t, \t", or "\t with ','
      if(i+1<values.length() && values.charAt(i+1) == '"') {
        values.replace(i,i+2,"','");
        i+=3;
      } else if(i>0 && values.charAt(i-1) == '"') {
        values.replace(i-1,i+1,"','");
        i+=2;
      } else {
        values.replace(i,i+1,"','");
        i+=3;
      }
      valueNum++;
    }
    // filling in empty fields
    while(valueNum<columnNum) {
      values.append("','");
      valueNum++;
    }

    sql.append("insert into " + table_name + " ");
//    sql.append("(" + columnNames.toString() + ") ");
    sql.append("values ('");
    sql.append(values.toString());
    sql.append("')");

    secondaryStmt.executeUpdate(sql.toString());
    
  }

  %>Dataset activated.<br/><%
} catch (SQLException se) {
    out.println("SQL Error message: " + se.getMessage() + ".<br/>");
    out.println("<p>in SQLStatement: " +sql.toString() + "</p>");
    se.printStackTrace();
} catch (Throwable ex) {
    out.println("IO Error.<br/>");
    ex.printStackTrace();
}finally{
  try {
    primaryStmt.close();
    secondaryStmt.close();
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
