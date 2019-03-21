<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<c:if test="${param.error != null}">
			<p style="color:red">Invalid login details!</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p style="color:green">You have been logged out!</p>
		</c:if>
		<p>
			<p>Username</p><input type="text" name="username" />
		</p>
		<p>
			<p>Password</p><input type="password" name="password" />
		</p>
		<p>
			<input type="submit" value="Login">
		</p>
	</form:form>
</body>
</html>