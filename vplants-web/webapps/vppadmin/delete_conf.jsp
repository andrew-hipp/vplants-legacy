<html>
<head>
<title>Delete dataset confirmation</title>
</head>

<body>
<jsp:include page="adminTop.html" flush="true"/>

Are you sure you want to delete the dataset?
<form method="POST" action="delete.jsp?table_id=<%= request.getParameter("table_id") %>&filename=<%= request.getParameter("filename") %>">
	<input type="hidden" name="database_id" value="<%= request.getParameter("database_id") %>">
	<input type="submit" name="Delete dataset" value="Delete dataset">
	<input type=Button name="Cancel" value="Cancel" onClick="window.location='datasets.jsp?table_id= <%= request.getParameter("table_id") %>'">
</form>

</body>
