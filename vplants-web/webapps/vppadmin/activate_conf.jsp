<html>
<head>
<title>Activate Dataset Confirmation</title>
</head>

<body>
<jsp:include page="adminTop.html" flush="true"/>

Are you sure you want to activate the dataset?
<form method="POST" action="activate.jsp?table_id=<%= request.getParameter("table_id") %>&filename=<%= request.getParameter("filename") %>">
	<input type="hidden" name="database_id" value="<%= request.getParameter("database_id") %>">
	<input type="submit" name="Activate dataset" value="Activate dataset">
	<input type=Button name="Cancel" value="Cancel" onClick="window.location='datasets.jsp?table_id= <%= request.getParameter("table_id") %>'">
</form>

</body>
