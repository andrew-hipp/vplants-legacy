<html>
<head>
<title>Upload dataset</title>
</head>

<body>
<jsp:include page="adminTop.html" flush="true"/>

<form method="POST" action="upload_dataset.jsp" enctype="multipart/form-data">
	<input type="hidden" name="database_id" value="<%= request.getParameter("database_id") %>">
	<input type="hidden" name="table_id" value="<%= request.getParameter("table_id") %>">
	Description: <input type="text maxlength="128" size="64" name="description"><br>
	File: <input type="file" name="file"><br>
	<input type="submit" name="Upload dataset" value="Create dataset">
</form>

</body>
 