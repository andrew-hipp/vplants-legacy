<html>
<head>
<title>Creating dataset</title>
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

BufferedWriter dataset = null;
String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
try{
  if(table_name == null) {
    %>Table not found.<br/><%
  } else {
    // get table data
    out.println("Loading " + table_name + " table data.<br/>");
    rs = secondaryStmt.executeQuery(
      "select * " +
      "from " + table_name
    );

    %>Saving table data.<br/><%
    dataset = new BufferedWriter(new FileWriter(path + "datasets/"+table_name+"_"+date+".txt"));

    // save column info
    int columnCount = rs.getMetaData().getColumnCount();
    String[] columnNames = new String[columnCount];
    for(int i=0; i<columnCount; i++) {
      columnNames[i]=rs.getMetaData().getColumnName(i+1);
      dataset.write(columnNames[i]);
      if(i!=columnCount-1) dataset.write("\t");
    }
    dataset.write("\n");

    int rows=0;
    // save all data by row
    while(rs.next()){
      rows++;
      for(int i=0; i<columnCount; i++) {
        if(rs.getString(i+1)!=null)
          dataset.write(rs.getString(i+1));
        if(i+1<columnCount) dataset.write("\t");
      }
      dataset.write("\n");
    }

    // update database for dataset
   primaryStmt.execute(
      "insert into datasets " +
      "(table_id,description,creation_date,filename,num_rows) " +
      "values ('" + table_id + "','" + 
        request.getParameter("description").replaceAll("'","''") + "'," +
        "to_date('"+date+"','yyyy-mm-dd_hh24-mi-ss')" + ",'" + 
        table_name+"_"+date+".txt','" + rows +
      "')"
    );
    %>Table data saved.<br/><%
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