<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login azienda</title>
</head>
<body>
<form:form action="processlogin" modelAttribute="responsabile">
Email: <form:input path="email"/>
	<div>${errMail}</div>
		<br>
		<br>
Password: <form:input path="password" />
<div>${errPasswss}</div>
		<br>
		<br>
<input type="submit" value="invia">



</form:form>
</body>
</html>