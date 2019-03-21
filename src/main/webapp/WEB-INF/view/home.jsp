<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1>Home</h1>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">		
		<p>
			<input type="submit" value="Logout">
		</p>
	</form:form>
</body>
</html>