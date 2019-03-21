<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome!</h1>
	<p>${pageContext.request.contextPath}</p>
	<a href=" home">Home</a>
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/showAdminPage">Admin</a>		
	</security:authorize>
	
</body>
</html>