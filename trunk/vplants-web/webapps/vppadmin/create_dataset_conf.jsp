<html>
<head>
<title>Create dataset from active data</title>
</head>

<body>
<jsp:include page="adminTop.html" flush="true"/>

<form method="POST" action="create_dataset.jsp?database_id=<%= request.getParameter("database_id") %>">
	Description: <input type="text maxlength="128" size="64" name="description">
	<input type="hidden" name="table_id" value="<%= request.getParameter("table_id") %>">
	<input type="submit" name="Create dataset" value="Create dataset">
</form>

</body>
 