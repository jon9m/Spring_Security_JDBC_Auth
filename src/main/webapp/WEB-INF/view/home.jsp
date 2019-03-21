<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	
	User : <security:authentication property="principal.username"/>
    Role : <security:authentication property="principal.authorities"/>
</body>
</html>